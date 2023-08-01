package io.javabrains.reactiveworkshop;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(el -> System.out.print(el + " "));

        // Print numbers from intNumbersStream that are less than 5
        System.out.println();
        StreamSources.intNumbersStream()
                .filter(integer -> integer < 5)
                .forEach(integer -> System.out.print(integer + " "));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println();
        StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .skip(1)
                .limit(2)
                .forEach(el -> System.out.print(el + " "));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println();
        Integer integer1 = StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(integer1);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(s -> System.out.print(s + " "));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println();
        StreamSources.userStream()
                .filter(user -> {
                    List<Integer> collect = StreamSources.intNumbersStream()
                            .filter(integer -> integer == user.getId())
                            .toList();
                    return collect.contains(user.getId());
                })
                .map(user -> user.getFirstName())
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream()
                        .filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.print(name + " "));

        // WITH anyMatch
        System.out.println();
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream()
                        .anyMatch(integer -> integer == user.getId()))
                .forEach(user -> System.out.print(user.getFirstName() + " "));

    }

}
