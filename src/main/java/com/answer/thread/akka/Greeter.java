package com.answer.thread.akka;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

    public static enum Msg{
        GREET , DONE;
    }

    public void onReceive(Object msg) throws Exception {
        if (msg == Msg.GREET) {
            System.out.println("hello world");
            getSender().tell(Msg.DONE , getSelf());
        }else {
            unhandled(msg);
        }
    }
}
