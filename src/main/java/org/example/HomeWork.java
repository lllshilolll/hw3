package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     * <p>
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     * <p>
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
    public String findMaxSubstring(String str) {
        int i = 0;
        List<Character> good = new LinkedList<>();
        while (i < str.length()) {
            List<Character> list = find(i, str);

            if (list.size() > good.size()) {
                good.clear();
                good.addAll(list);
            }
            i = i + good.size();
        }
        return good.stream().map(Object::toString).collect(Collectors.joining());
    }


    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     * <p>
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     *
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    public boolean check(String sentence) {
//        List<Character> charArray = Arrays.stream(IntStream.rangeClosed('A', 'Z')
//                        .mapToObj(c -> (char) c)
//                        .toArray(Character[]::new))
//                .collect(Collectors.toList());
//
//        char[] test = sentence.toUpperCase().toCharArray();
//
//        Set<Character> newArray = Arrays.stream(IntStream.range(0, test.length)
//                        .mapToObj(i -> test[i])
//                        .toArray(Character[]::new))
//                .collect(Collectors.toSet());
//        return newArray.containsAll(charArray);

        return 26 == sentence.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .filter(f -> f >= 'A' && f <= 'Z')
                .distinct()
                .count();
    }

    private LinkedList<Character> find(int i, String str) {
        char[] array = str.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            } else {
                break;
            }
        }
        return list;
    }

}
