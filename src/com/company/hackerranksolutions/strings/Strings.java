package com.company.hackerranksolutions.strings;

import java.util.*;

public class Strings {

    public static int camelcase(String s) {
        //As the first word start from lowerCase
        int counter = 1;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                counter++;
            }
        }
        return counter;
    }

    public static String superReducedString(String s) {
        //Use StringBuilder class for make mutable String variables
        StringBuilder string = new StringBuilder(s);
        boolean check = true;
        while (check) {
            check = false;
            for (int i = 0; i < string.length() - 1; i++) {
                if (string.charAt(i) == string.charAt(i + 1)) {
                    string.delete(i, i + 2);
                    check = true;
                }
            }
        }
        if (string.length() == 0) {
            return "Empty String";
        } else {
            return string.toString();
        }
    }

    public static int minimumNumber(int n, String password) {
        int counter = 4;

        if (password.matches("(.*)[A-Z](.*)")) counter--;

        if (password.matches("(.*)[a-z](.*)")) counter--;

        if (password.matches("(.*)[0-9](.*)")) counter--;

        if (password.matches("(.*)[!@#$%^&*()\\-+](.*)")) counter--;

        return Math.max(counter, 6 - n);
    }

    public static int marsExploration(String s) {
        int counter = 0;
        int currentPosition = 0;
        for (char letter : s.toCharArray()) {
            if (currentPosition % 3 == 1) {
                counter += (letter != 'O') ? 1 : 0;
            } else {
                counter += (letter != 'S') ? 1 : 0;
            }
            currentPosition++;
        }
        return counter;
    }

    public static String caesarCipher(String s, int k) {
        //Used formula (x + n)%26 for encryption
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append((char) ('a' + ((ch - 'a') + k) % 26));
            } else if (ch >= 'A' && ch <= 'Z') {
                stringBuilder.append((char) ('A' + ((ch - 'A') + k) % 26));
            } else {
                stringBuilder.append(ch);
            }
        }
        s = stringBuilder.toString();
        return s;
    }

    public static String hackerrankInString(String s) {
        int counter = 0;
        String checkWord = "hackerrank";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == checkWord.charAt(i))
                counter++;
            if (counter == checkWord.length()) {
                return "YES";
            }
        }
        return "NO";
    }

    public static boolean isPangram(String s) {
        String lowerCase = s.toLowerCase();
        for (char ch = 'a'; ch < 'z'; ch++) {
            //Using not charAt(i) function
            if (lowerCase.indexOf(ch) < 0) return false;
        }
        return true;
    }

    public static String pangrams(String s) {
        return (isPangram(s)) ? "pangram" : "not pangram";
    }

    public static int alternatingCharacters(String s) {
        int counter = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                counter++;
            }
        }
        return counter;
    }

    public static int beautifulBinaryString(String b) {
        int counter = 0;
        int i = 0;
        while (i < b.length() - 2) {
            if (b.startsWith("010", i)) {
                counter++;
                i += 3;
            } else {
                i++;
            }
        }
        return counter;
    }

    public static int theLoveLetterMystery(String s) {
        //How many operations needed to make palindrome
        int operationsPerformed = 0;
        //The first character in the string
        int i = 0;
        //The last character in the string
        int j = s.length() - 1;
        //At each
        //iteration check which one is greater and
        //reduce that one by their difference in
        //ASCII value. Add that difference to the
        //operations counter
        while (i < j) {
            operationsPerformed += Math.abs(s.charAt(i) - s.charAt(j));
            i++;
            j--;
        }
        return operationsPerformed;
    }

    public static int gemstones(List<String> arr) {
        String[] array = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }
        int count = 0;
        for (int i = 97; i <= 122; i++) {
            char ch = (char) i;
            for (int j = 0; j < arr.size(); j++) {
                if (array[j].indexOf(ch) == -1) {
                    break;
                } else if (j == arr.size() - 1 && array[j].indexOf(ch) != -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Set<Character> stringToSet(String s) {
        Set<Character> set = new HashSet<>(26);
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        return set;
    }

    public static int makingAnagrams(String s1, String s2) {
        int counter = 0;
        int[] s1array = new int[26];
        int[] s2array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int position = (int) ch - (int) 'a';
            s1array[position]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            int position = (int) ch - (int) 'a';
            s2array[position]++;
        }

        for (int i = 0; i < 26; i++) {
            int diff = Math.abs(s1array[i] - s2array[i]);
            counter += diff;
        }
        return counter;
    }

    public static String gameOfThrones(String s) {
        //Create and initialize array with values of 0
        int[] count = new int[256];
        Arrays.fill(count, 0);

        for (int i = 0; i < s.length(); i++) {
            count[(s.charAt(i))]++;
        }

        int odd = 0;
        for (int i = 0; i < 256; i++) {
            if ((count[i] & 1) == 1)
                odd++;
            if (odd > 1)
                return "NO";
        }
        return "YES";
    }

    public static String funnyString(String s) {
        StringBuilder reversedS = new StringBuilder(s);
        reversedS.reverse();

        int[] original = new int[s.length()];
        for (int i = 0; i < original.length; i++) {
            int n = s.charAt(i);
            original[i] = n;
        }

        int[] reversed = new int[reversedS.length()];
        for (int i = 0; i < reversed.length; i++) {
            int n = s.charAt(i);
            reversed[i] = n;
        }

        int[] originalDiff = new int[original.length - 1];
        for (int i = 0; i < original.length - 1; i++) {
            int value = Math.abs(original[i] - original[i + 1]);
            originalDiff[i] = value;
        }

        int[] reversedDiff = new int[reversed.length - 1];
        for (int i = 0; i < reversed.length - 1; i++) {
            int value = Math.abs(reversed[i] - reversed[i + 1]);
            reversedDiff[i] = value;
        }
        String result = null;

        for (int i = 0; i < reversedDiff.length; i++) {
            result = (reversedDiff[i] != originalDiff[i]) ? "Funny" : "Not Funny";
        }
        return result;
    }

    public static int stringConstruction(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

    public static String twoStrings(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }

        set1.retainAll(set2);

        if (set1.size() > 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static int anagram(String s) {
        int result = 0;
        if ((s.length() % 2) == 0) {
            Map<Character, Integer> fH = new HashMap<>();
            Map<Character, Integer> sH = new HashMap<>();

            for (int i = 0; i < s.length() / 2; i++) {
                if (fH.containsKey(s.charAt(i))) {
                    fH.put(s.charAt(i), fH.get(s.charAt(i)) + 1);
                } else {
                    fH.put(s.charAt(i), 1);
                }
            }

            for (int i = s.length() / 2; i < s.length(); i++) {
                if (sH.containsKey(s.charAt(i))) {
                    sH.put(s.charAt(i), sH.get(s.charAt(i)) + 1);
                } else {
                    sH.put(s.charAt(i), 1);
                }
            }

            for (Map.Entry<Character, Integer> letter : sH.entrySet()) {
                int f2 = letter.getValue();
                int f1 = (fH.get(letter.getKey()) != null) ? fH.get(letter.getKey()) : 0;

                if (f2 > f1) {
                    result += (f2 - f1);
                }
            }
        } else {
            result = -1;
        }
        return result;
    }

    public static void separateNumbers(String s) {
        String subString = "";
        boolean isValid = false;
        for (int i = 1; i <= s.length() / 2; i++) {
            subString = s.substring(0, i);
            long num = Long.parseLong(subString);
            StringBuilder validString = new StringBuilder(subString);
            while (validString.length() < s.length()) {
                validString.append(++num);
            }
            if (s.equals(validString.toString())) {
                isValid = true;
                break;
            }
        }
        System.out.println(isValid ? "YES " + subString : "NO");
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        char prev = s.charAt(0);
        set.add(prev - 'a' + 1);
        int sum = prev - 'a' + 1;
        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            if (next == prev) {
                sum += (prev - 'a' + 1);
                set.add(sum);
            } else {
                set.add(next - 'a' + 1);
                prev = next;
                sum = prev - 'a' + 1;
            }
        }
        for (int e : queries) {
            if (set.contains(e)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;
    }

    //Not the hackerrank problem
    public static boolean checkForPalindrome(String input) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder(input.length());
        String lowerCase = input.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char ch = lowerCase.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                builder.append(ch);
                stack.push(ch);
            }
        }

        StringBuilder reversed = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString().equals(builder.toString());
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        return true;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] a1 = a.toLowerCase().toCharArray();
        char[] a2 = b.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    /**
     * Increment the value in count array for characters in str1 and decrement in str2
     * Finally , if all count values are 0  , then two strings are anagram of each other
     */
    public static boolean isAnaram1(String a, String b) {
        char[] stringA = a.toCharArray();
        char[] stringB = b.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < a.length(); i++) {
            count[stringA[i] - 'a']++;
            count[stringB[i] - 'a']--;
        }

        if (stringA.length != stringB.length) {
            return false;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int mostWordsFound(String[] sentences) {
        int length = sentences.length;
        int[] result = new int[length];
        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");
            result[i] = words.length;
        }
        Arrays.sort(result);
        return result[length - 1];
    }


    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //Key is teh size of the group , Value is the list of integers
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int key : map.keySet()) {
            int i = 0;
            List<Integer> list = map.get(key);
            do {
                result.add(list.subList(i, i + key));
                i += key;
            } while (i + key <= list.size());
        }
        return result;
    }

    public void cycleRotation(String s1, String s2) {
        /* LOGIC
         * concatenate string 1 with string 1. Then, try to find the
         * string 2 in concatenated string. If string 2 is present in
         * concatenated string then, string 2 is rotation of string 1.
         */
        if (s1.length() == s2.length()) {
            System.out.println("Second string is not a rotation of first string");
        } else {
            s1 = s1.concat(s2);
            if (s1.contains(s2)) {
                System.out.println("Second string is rotation of first string");
            } else {
                System.out.println("Second string is not rotation of first string");
            }
        }
    }

    //Actually it reverses the string
    public static String mystery(String s) {
        int N = s.length();
        //SET UP CONDITION FOR RECURSION
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        //NOTE THAT THIS IS RECURSION METHOD
        return mystery(b) + mystery(a);
    }
}