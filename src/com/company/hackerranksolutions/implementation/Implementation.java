package com.company.hackerranksolutions.implementation;

import com.company.hackerranksolutions.warmup.WarmUp;

import java.math.BigInteger;
import java.util.*;

public class Implementation {

    private static List<Integer> graduateStudents(List<Integer> grades) {
        //Create the new list for storing our results
        List<Integer> resultList = new ArrayList<>();
        //Iterate through the input list
        for (int x : grades) {
            /*The most interesting part is how rounding works here
            (48 + 5 - 48 % 5) - 48 = 53 - 3 - 48 = 2 < 3
            (48 + 5 - 48 % 5) = 53 - 3 = 50 which is nearest multiple by 5
             */
            if (x >= 38 && (x + 5 - x % 5) - x < 3) {
                int item = x + 5 - x % 5;
                resultList.add(item);
            } else {
                resultList.add(x);
            }
        }
        return resultList;
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        //Create lists for holding modified values
        ArrayList<Integer> appleList = new ArrayList<>();
        ArrayList<Integer> orangesList = new ArrayList<>();
        //storing items in it
        int apple;
        int orange;
        //Loop for apples
        for (Integer integer : apples) {
            apple = integer + a;
            if (apple >= s && apple <= t) {
                appleList.add(apple);
            }
        }
        //Loops for oranges
        for (Integer integer : oranges) {
            orange = integer + b;
            if (orange >= s && orange <= t) {
                orangesList.add(orange);
            }
        }
        System.out.println(appleList.size() + "\n" + orangesList.size());
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        //Create an array for storing min and max
        List<Integer> results = new ArrayList<>();
        //storing the minimum and maximum values
        int minimum = scores.get(0);
        int maximum = scores.get(0);
        //counters for them
        int min = 0;
        int max = 0;
        //Iterate through the list
        // 10(initial) 5 20 20 4 5 2 25 1
        for (Integer score : scores) {
            if (score < minimum) {
                minimum = score;
                min++;
            } else if (score > maximum) {
                maximum = score;
                max++;
            }
        }
        results.add(max);
        results.add(min);

        return results;
    }

    public static int birthday(List<Integer> s, int d, int m) {
        //startIndex
        //int startIndex = 0;
        //Counter for storing segments
        int count = 0;
        //Sublist which we will use for segments
        //List<Integer> subList;

        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum = sum + s.get(j);
            }
            if (sum == d) {
                count++;
            }
            /*summing the elements in subList
            subList = s.subList(startIndex, m);
            int sumSubList = simpleArraySum(subList);
            if (sumSubList == d) {
                counter++;
            }
            startIndex++;
            m += 1;*/
        }
        return count;
    }

    public static int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGCD(n2, n1 & n2);
    }

    public static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        } else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer);
        }

        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer);
        }

        int multiple = 0;
        while (multiple <= gcd) {
            multiple += gcd;
            if (gcd % multiple == 0)
                result++;
        }

        return result;

    }

    public static int migratoryBirds(List<Integer> arr) {
        int[] array = new int[5];
        for (Integer integer : arr) {
            switch (integer) {
                case 1 -> array[0]++;
                case 2 -> array[1]++;
                case 3 -> array[2]++;
                case 4 -> array[3]++;
                case 5 -> array[4]++;
            }
        }
        int highest = 0;
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            if (array[i] > highest) {
                highest = array[i];
                answer = i + 1;
            }
        }
        return answer;
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 > v2) {
            int remainder = (x1 - x2) % (v1 - v2);
            if (remainder == 0) {
                return "YES";
            }
        }
        return "NO";
    }

    public static String dayOfProgrammer(int year) {
        int februaryDays = 0;
        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                februaryDays = 29;
            } else {
                februaryDays = 28;
            }
        } else if (year == 1918) {
            februaryDays = 15;
        } else if (year >= 1919) {
            if ((year % 4 == 0) && ((year % 400 == 0) || (year % 100 != 0))) {
                februaryDays = 29;
            } else {
                februaryDays = 28;
            }
        }
        int dateOfTheProgramme = 256 - (215 + februaryDays);
        String dateDay = String.valueOf(dateOfTheProgramme);
        String dateMonth = "09";
        String dateYear = String.valueOf(year);
        return dateDay + "." + dateMonth + "." + dateYear;

    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int chargedBill = WarmUp.simpleArraySum(bill) / 2;
        int actualBill = (WarmUp.simpleArraySum(bill) - bill.get(k)) / 2;
        int difference = chargedBill - actualBill;
        if (actualBill == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(difference);
        }
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        //Sort elements of the array
        Collections.sort(ar);

        //get the first value of the array
        int currentValue = ar.get(0);
        //counter
        int counter = 0;
        //pair
        int pair = 0;

        for (Integer element : ar) {
            if (element == currentValue) {
                counter++;
                if (counter == 2) {
                    pair++;
                    counter -= 2;
                }
            } else {
                currentValue = element;
                counter = 1;
            }
        }
        return pair;
    }

    public static int pageCount(int n, int p) {
        int middle = n / 2;
        int result = 0;
        if (p >= 1 && p <= n) {
            if (p > middle) {
                result = n - p;
            } else {
                result = p - 2;
            }
        }
        return result;
    }

    public static int countingValleys(int steps, String path) {
        //Used for counting the path of the hiker
        int pathCounter = 0;
        //Used for storing amount of valleys passed
        int countValley = 0;
        //get an array from "path" String
        for (int i = 0; i < steps; i++) {
            //how we get an element from the String;
            char ch = path.charAt(i);
            if (ch == 'U') {
                pathCounter++;
                if (pathCounter == 0) {
                    countValley++;
                }
            } else {
                pathCounter--;
            }
        }
        return countValley;
    }

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        //Store our element
        int result = 0;
        int resultElement = 0;
        //nested loops
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                resultElement = keyboard + drive;
                if (resultElement >= result && resultElement <= b) {
                    result = resultElement;
                }
            }
        }
        if (result == 0) return -1;
        return result;
    }

    static int formingMagicSquare(List<List<Integer>> s) {
        int minCost = Integer.MAX_VALUE;
        int[][][] t = {
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
        };
        for (int m = 0; m < 8; m++) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(s.get(i).get(j) - t[m][i][j]);
                }
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public static int pickingNumbers(List<Integer> a) {
        //Created an array with inclusive range of 100 elements
        int[] array = new int[100];

        int subArray = 0;

        for (int value : a) {
            array[value]++;
        }

        for (int i = 0; i + 1 < a.size(); i++) {
            int currentLong = array[i] + array[i + 1];
            if (currentLong > subArray) {
                subArray = currentLong;
            }
        }
        return subArray;
    }

    public static int hurdleRace(int k, List<Integer> height) {
        int result = 0;
        int max = 0;
        for (int element : height) {
            if (element >= max) {
                max = element;
            }
        }
        if (max > k) {
            result = max - k;
        }
        return result;
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        int max = -1;
        for (int i = 0; i < word.length(); i++) {
            int ASCII = word.charAt(i);
            int val = ASCII - 97;
            if (h.get(val) > max) {
                max = h.get(val);
            }
        }
        return word.length() * max;
    }

    public static int utopianTree(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result = result * 2;
            } else {
                result += 1;
            }
        }
        return result;
    }

    public static String angryProfessor(int k, List<Integer> a) {
        int counter = 0;
        //Loop for checking the arrival time
        for (int element : a) {
            if (element <= 0) {
                counter++;
            }
        }

        return ((counter >= k) ? "NO" : "YES");
    }

    //finish
    public static int beautifulDays(int i, int j, int k) {
        //Count how many values are beautifulNumbers
        int counter = 0;
        //holder for number
        int beautifulNumber;
        //loop for reversing the number
        for (int start = i; i < j; i++) {
            //Here we will get reversed number in order to calculate beautiful number
            int reverse = 0;
            //Make calculations to get reversed number
            while (start != 0) {
                int remainder = start % 10;
                reverse = reverse * 10 + remainder;
                start = start / 10;
            }
            //Calculate the difference between actual and reversed number
            beautifulNumber = (start - reverse);
            //Check if the remainder even divisible k or not
            if (beautifulNumber % k == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int viralAdvertising(int n) {
        //Store liked values
        int cumulative = 0;
        //Initial value of shared elements is 5
        int shared = 5;
        //Creating the loop
        for (int i = 0; i < n; i++) {
            //divide shared elements to get liked posts
            int liked = shared / 2;
            //store liked values in another data holder
            cumulative += liked;
            //multiply shared values
            shared = liked * 3;
        }
        return cumulative;
    }

    public static int saveThePrisoner(int n, int m, int s) {
        int result = m % n;
        if ((result + s - 1) % n == 0) {
            return n;
        } else {
            return ((result + s - 1) % n);
        }
    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();

        k = k % a.size();
        if (k <= 0) {
            k = k * a.size();
        }

        swap(a, 0, a.size() - k - 1);
        swap(a, a.size() - k, a.size() - 1);
        swap(a, 0, a.size() - 1);

        for (Integer query : queries) {
            int p = a.get(query);
            list.add(p);
        }
        return list;
    }

    public static void swap(List<Integer> list, int i, int j) {

        /* First Version
         for (int j = 0; j < k; j++) {
         for (int i = 0; i < a.size(); i++) {
             int temp = a.get(i);
             a.set(i, a.get(a.size() - 1));
             a.set(a.size() - 1, temp);
             queries.add(a.get(i));
             }
         }
        return queries.subList(queries.size() - a.size(), queries.size());*/
        int l = i;
        int r = j;
        while (l < r) {
            int temp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, temp);
            l++;
            r--;
        }
    }

    public static int jumpingOnClouds(int[] c, int k) {
        //energy level
        int e = 100;
        int i = 0;
        int n = c.length;
        do {
            if (c[i] == 1) {
                //simple + extra = 1 + 2
                e -= 3;
            } else {
                e -= 1;
            }
            //get the index of the place where u need to jump
            i = (i + k) % n;
        } while (i != 0);
        return e;
    }

    public static int findDigits(int n) {
        //counting how many divisors the number have
        int counter = 0;
        //??????? Why should we save the value??
        int num = n;
        //loop until t reaches 0
        while (n > 0) {
            //get the digit from the number
            int number = n % 10;
            //check if digit equals 0 , avoid divide bt zero error
            if (number != 0) {
                //check if number is evenly divided by digit
                if (num % number == 0) {
                    //update divisible counter
                    counter++;
                }
            }
            n = n / 10;
        }
        return counter;
    }

    public static int squares(int a, int b) {
        int A = (int) Math.sqrt(a);
        int B = (int) Math.sqrt(b);
        int res = B - A;
        if (A * A >= a)
            res++;
        return res;
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        //Store fine value
        int fine = 0;
        if ((d1 <= d2) && m1 == m2 && y1 == y2) {
            return fine;
        } else if ((d1 >= d2) && m1 == m2 && y1 == y2) {
            fine = (d1 - d2) * 15;
            return fine;
        } else if (m1 > m2 && y1 == y2) {
            fine = (m1 - m2) * 500;
            return fine;
        } else if (y1 > y2) {
            fine = 10000;
            return fine;
        }
        return fine;
    }

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        //Init list for sizes
        ArrayList<Integer> size = new ArrayList<>();

        while (arr.size() != 0) {
            //get size of the array before the manipulations on it
            size.add(arr.size());
            //get min value in the array
            int min = Collections.min(arr);
            //remove the min element in the array
            arr.removeAll(Collections.singleton(min));
            //iterate over collection without the lowest element
            for (int i = 0; i < arr.size(); i++) {
                //overwrite the initial values with modified values
                arr.set(i, arr.get(i) - min);
            }
        }
        return size;
    }

    public static long repeatedString(String s, long n) {
        long countForSubstring = 0;
        long totalCount = 0;

        //Determines how many a's are in a substring
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countForSubstring++;
            }
        }


        //Determines how many complete substrings we will analyze
        long divisor = n / s.length();

        totalCount += divisor * countForSubstring;


        //Determines how many characters in we will analyze towards the end of our n range
        long remainder = n % s.length();

        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                totalCount++;
            }
        }
        return totalCount;
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;
        for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if (((ar.get(i) + ar.get(j)) % k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigInteger);
    }

    public static int equalizeArray(List<Integer> arr) {
        //size of input array
        int length = arr.size();
        int[] array = new int[101];
        for (int value : arr) {
            array[value]++;
        }
        int maxFreqCount = getMaxFreqValue(array);
        return length - maxFreqCount;
    }

    private static int getMaxFreqValue(int[] array) {
        int maxFreqCount = Integer.MIN_VALUE;
        for (int freqCount : array) {
            if (freqCount > maxFreqCount) {
                maxFreqCount = freqCount;
            }
        }
        return maxFreqCount;
    }

    public static List<Integer> permutationEquation(List<Integer> p) {
        int n = p.size();

        ArrayList<Integer> all = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            all.add(p.indexOf(i) + 1);
        }
        ArrayList<Integer> all2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            all2.add(p.indexOf(all.get(i)) + 1);
        }
        return all2;
    }

    public static String appendAndDelete(String s, String t, int k) {
        //hold index for s and t strings
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            //check if word have equals words
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                break;
            }
        }

        int minOperations = 0;
        minOperations = s.length() - sIndex + t.length() - tIndex;
        if (k < minOperations) return "No";

        if (k >= s.length() + t.length()) return "Yes";

        if ((k - minOperations) % 2 == 0) return "Yes";

        return "No";
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int length = c.size();
        int count = -1;

        for (int i = 0; i < length; i++, count++) {
            if (i + 2 < length && c.get(i + 2) == 0) {
                i++;
            }
        }
        return count;
    }

    public static List<Integer> acmTeam(List<String> topic) {
        int n = topic.size();
        BigInteger[] integer = new BigInteger[n];

        for (int i = 0; i < n; i++) {
            integer[i] = new BigInteger(topic.get(i), 2);
        }
        int maxCount = 0;
        int teamCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BigInteger iuj = integer[i].or(integer[j]);
                int bitCount = iuj.bitCount();
                if (bitCount > maxCount) {
                    maxCount = bitCount;
                    teamCount = 1;
                } else if (bitCount == maxCount) {
                    teamCount++;
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(maxCount);
        list.add(teamCount);
        return list;

    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long result = 0;
        long minBlackPrice = Math.min(bc, wc + z);

        long minWhitePrice = Math.min(wc, bc + z);

        result = ((minBlackPrice * b) + (minWhitePrice * w));

        return result;
    }

    public static int minimumDistances(List<Integer> a) {
        //Always set up the value for data holder
        int min = Integer.MAX_VALUE;
        //Outer loop to iterate over the elements
        for (int i = 0; i < a.size(); i++) {
            //Inner lop to iterate element over the elements
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).equals(a.get(j))) {
                    int temp = j - i;
                    if (temp < min) {
                        min = temp;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE)
            min = -1;

        return min;
    }

    //Try later with Set
    public static int beautifulTriplets(int d, List<Integer> arr) {
        int tripletCounter = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                if (arr.get(j) - arr.get(i) == d) {
                    for (int k = j + 1; k < arr.size(); k++) {
                        if (arr.get(k) - arr.get(j) == d) {
                            tripletCounter++;
                            break;
                        }
                    }
                }
            }
        }
        return tripletCounter;
    }

    public static int howManyGames(int p, int d, int m, int s) {
        //declare counter for elements
        int count = 0;
        //init counter by initial price
        int priceCounter = p;
        //while wallet is less than or equal to priceCounter
        while (s >= priceCounter) {
            count++;
            //subtract price from wallet
            s -= priceCounter;
            //Math max function will choose between 2 prices on each iteration
            priceCounter = Math.max(priceCounter - d, m);
        }
        return count;
    }

    public static int chocolateFeast(int n, int c, int m) {
        //Chocolate Bars bought
        int chocolateBar = n / c;
        //wrappers to exchange
        int wrapper = chocolateBar;
        //Chocolates eaten counter
        int count = chocolateBar;

        if (chocolateBar < m) {
            return count;
        } else {
            while (wrapper >= m) {
                chocolateBar += 1;
                wrapper = wrapper - m + 1;
            }
        }
        return count;
    }

    public static int workbook(int n, int k, List<Integer> arr) {
        //Data Holder for number
        int magicNumber = 0;
        //Page number
        int pageNumber = 1;
        //Outer loop to pass through the list of chapters
        for (int element : arr) {
            //inner loop to pass though exercises in each chapter
            for (int j = 1; j <= element; j += k) {
                //each page contain k elements
                int currentPage = k;
                if (j + k - 1 > element) {
                    currentPage = element % k;
                }
                if (j <= pageNumber && pageNumber < j + currentPage) {
                    magicNumber++;
                }
                pageNumber++;
            }
        }
        return magicNumber;
    }

    public static String fairRations(List<Integer> B) {
        int counter = getMinLoaveCount(B);
        return counter != -1 ? Integer.toString(counter) : "NO";
    }

    private static int getMinLoaveCount(List<Integer> B) {
        int minLovesCount = 0, sum = 0;
        for (Integer integer : B) {
            sum += integer;

            if (sum % 2 == 1) {
                minLovesCount += 2;
            }
        }
        return ((sum & 1) == 1) ? -1 : minLovesCount;
    }

    public static List<Integer> stones(int n, int a, int b) {
        List<Integer> list = new ArrayList<>();
        int temp = Math.max(a, b);
        a = Math.min(a, b);
        b = temp;
        int x = Math.abs(a - b);
        if (x == 0) {
            x = a;
        }
        for (int i = a * (n - 1); i <= b * (n - 1); i += x) {
            list.add(i);
        }
        return list;
    }

    //NOT WORKING
    public static List<Integer> serviceLane(int n, List<List<Integer>> cases) {
        List<Integer> result = new ArrayList<>(cases.size());
        for (int i = 0; i < cases.size(); i++) {
            int min = 3;
            for (int j = cases.get(i).get(0); j <= cases.get(i).get(1); j++) {
                min = Math.min(min, n);
            }
            result.set(i, min);
        }
        return result;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ArrayList<Integer> leaderboard = (ArrayList<Integer>) ranked;
        ArrayList<Integer> playerScores = (ArrayList<Integer>) player;
        List<Integer> ranks = new ArrayList<>();
        Map<Integer, Integer> ranking = new HashMap<>();
        int rank = 1;
        for (Integer integer : leaderboard) {
            if (!ranking.containsKey(integer)) {
                ranking.put(integer, rank++);
            }
        }
        int initial = leaderboard.size() - 1;
        for (int score : playerScores) {
            for (int i = initial; i >= 0; i--) {
                if (score >= leaderboard.get(i)) {
                    rank = ranking.get(leaderboard.get(i));
                    initial = i - 1;
                } else break;
            }
            ranks.add(rank);
        }
        return ranks;
    }

    public static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekarNumber(i)) {
                System.out.print("" + i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("INVALID RANGE");
        }
    }

    private static boolean isKaprekarNumber(int n) {
        long square = (long) n * n;
        String l = "" + n;
        String tmp = "" + square;
        int diff = tmp.length() - l.length();
        long right = Long.parseLong(tmp.substring(diff));
        if (tmp.length() == l.length()) {
            return n == right;
        }
        long left = Long.parseLong(tmp.substring(0, diff));
        return (right + left) == n;
    }

    public static String timeInWords(int h, int m) {
        String[] word = {
                "",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty one",
                "twenty two",
                "twenty three",
                "twenty four",
                "twenty five",
                "twenty six",
                "twenty seven",
                "twenty eight",
                "twenty nine"
        };

        String time;

        if (m == 0) {
            time = word[h] + " o' clock";
        } else if (m == 15) {
            time = "quarter past " + word[h];
        } else if (m == 30) {
            time = "half past " + word[h];
        } else if (m == 45) {
            time = "quarter to " + word[h + 1];
        } else if (m == 1) {
            time = word[m] + " minute past " + word[h];
        } else if (m < 30) {
            time = word[m] + " minutes past " + word[h];
        } else {
            time = word[60 - m] + " minutes to " + word[h + 1];
        }
        return time;
    }

    public static String biggerIsGreater(String w) {
        char[] array = new char[w.length()];
        int n = array.length;
        int endIndex = 0;
        /*
         * Start from the right most character and find the first character
         * that is smaller than previous one
         */
        for (endIndex = n - 1; endIndex > 0; endIndex--) {
            if (array[endIndex] > array[endIndex - 1]) {
                break;
            }
        }
        /*
         * If no such element is found , then all characters are in the descending order
         * means there cannot be a greater string with the same set of characters
         */
        if (endIndex == 0) {
            return "no answer";
        } else {
            int firstSmallerCharacter = array[endIndex - 1];
            int nextSmallerChar = endIndex;
            /*
             * Find the smallest character on right side of (endIndex -1)'th
             * character that is greater than array[endIndex - 1]
             */
            for (int startIndex = endIndex + 1; startIndex < n; startIndex++) {
                if (array[startIndex] > firstSmallerCharacter && array[startIndex] < array[nextSmallerChar]) {
                    nextSmallerChar = startIndex;
                }
            }
            swapCharArray(array, endIndex - 1, nextSmallerChar);
            Arrays.sort(array, endIndex, n);
        }
        return new String(array);
    }

    private static void swapCharArray(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainders = new int[k];
        for (int num : s) {
            int index = num % k;
            remainders[index]++;
        }

        int size = 0;
        for (int i = 1; i <= k / 2; i++) {
            if (i * 2 == k) {
                size++;
            } else {
                size += Math.max(remainders[i], remainders[k - i]);
            }
        }
        return remainders[0] != 0 ? size + 1 : size;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (List<Integer> obstacle : obstacles) {
            if (!map.containsKey(obstacle.get(0))) {
                map.put(obstacle.get(0), new HashSet<Integer>());
            }
            map.get(obstacle.get(0)).add(obstacle.get(1));
        }
        int counter = 0;
        for (int i = c_q + 1; i <= n; i++) {
            if (map.containsKey(r_q) && map.get(r_q).contains(i)) {
                break;
            }
            counter++;
        }

        // left
        for (int i = c_q - 1; i >= 1; i--) {
            if (map.containsKey(r_q) && map.get(r_q).contains(i)) {
                break;
            }
            counter++;
        }

        // down
        for (int i = r_q + 1; i <= n; i++) {
            if (map.containsKey(i) && map.get(i).contains(c_q)) {
                break;
            }
            counter++;
        }

        // up
        for (int i = r_q - 1; i >= 1; i--) {
            if (map.containsKey(i) && map.get(i).contains(c_q)) {
                break;
            }
            counter++;
        }

        // up-left
        for (int i = r_q - 1, j = c_q - 1; i >= 1 && j >= 1; i--, j--) {
            if (map.containsKey(i) && map.get(i).contains(j)) {
                break;
            }
            counter++;
        }

        // up-right
        for (int i = r_q - 1, j = c_q + 1; i >= 1 && j <= n; i--, j++) {
            if (map.containsKey(i) && map.get(i).contains(j)) {
                break;
            }
            counter++;
        }

        // down-right
        for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
            if (map.containsKey(i) && map.get(i).contains(j)) {
                break;
            }
            counter++;
        }

        // down-left
        for (int i = r_q + 1, j = c_q - 1; i <= n && j >= 1; i++, j--) {
            if (map.containsKey(i) && map.get(i).contains(j)) {
                break;
            }
            counter++;
        }
        return counter;
    }

    public static String encryption(String s) {
        int length = s.length();
        double rows = Math.floor(Math.sqrt(length));
        double cols = Math.ceil(Math.sqrt(length));
        int len = (int) (Math.max(rows, cols));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < length; j = (int) (j + cols)) {
                char ch = s.charAt(j);
                result.append(ch);
            }
            result.append(" ");
        }
        return result.toString();
    }

    public static String organizingContainers(List<List<Integer>> container) {
        //The general rule is thus: put the balls of which you have the least in
        // the container that has the smallest capacity. If that number of balls doesn't match the capacity,
        // then there is just no way to get to a solution. If it does match, then you can repeat this with the
        // next kind of balls (in increasing order) and next container (in increasing capacity). And so you
        // see that actually sorting the containers and balls like that is a way to find a solution.
        int n = container.size();
        int[] type = new int[n];
        int[] capa = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                type[j] += container.get(i).get(j);
                capa[i] += container.get(i).get(j);
            }
        }
        Arrays.sort(type);
        Arrays.sort(capa);
        for (int i = 0; i < type.length; i++) {
            if (type[i] != capa[i])
                return "Impossible";
        }
        return "Possible";
    }
}