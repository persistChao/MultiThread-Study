package com.answer.thread.chapter4.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 实现无锁的vector
 * Created by chao on 2018/3/17.
 */
public class  LockFreeVector<E>  {
    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
    public LockFreeVector() {
        buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(30);
        buckets.set(0,new AtomicReferenceArray<E>(8));
//        descriptor = new AtomicReference<Descriptor<E>>(new Descriptor<E>(0,null));
    }
    static class Descriptor<E> {
        public int size;
        volatile WriteDescriptor<E> writeop;
        public Descriptor(int size , WriteDescriptor<E> writeop) {
            this.size = size;
            this.writeop = writeop;
        }
        public  void completeWrite() {
            WriteDescriptor<E> tmpOp = writeop;
            if (tmpOp != null) {
                tmpOp.doIt();
                writeop = null;
            }
        }
    }
    static class WriteDescriptor<E> {
        public E oldV;
        public E newV;
        public AtomicReferenceArray<E> addr;
        public int addr_ind;

        public WriteDescriptor(AtomicReferenceArray<E> addr , int addr_ind,E oldV, E newV) {
            this.addr = addr;
            this.addr_ind = addr_ind;
            this.oldV = oldV;
            this.newV = newV;
        }

        public void doIt() {
            addr.compareAndSet(addr_ind , oldV , newV);
        }
    }
}
