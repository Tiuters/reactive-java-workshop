package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(integer -> System.out.println(integer),
//                        throwable -> System.out.println("Error happend"));

//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(throwable -> System.out.println("Error!!! " + throwable.getMessage()))
//                .subscribe(integer -> System.out.println(integer));

        // Print values from intNumbersFluxWithException and continue on errors
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((e, item) -> System.out.println("Error!!! " + e.getMessage() + "  Item:" + item))
//                .subscribe(integer -> System.out.println(integer));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(e -> Flux.just(-1, -2))
                .subscribe(integer -> System.out.println(integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
