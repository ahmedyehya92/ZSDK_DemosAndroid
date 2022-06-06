package com.zebra.android.devdemo.receipt;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertToArabic {
    static String finalWord = "";
    static int slashNb;
    static int num;
    static int time;
    static int notarabic = 0;

    public static String convertToarab(String arabString) {
        try {

            finalWord = "";

            String[] array = spliString(arabString, true);
            for (int j = 0; j < array.length; j++) {
                //   if (!array[j].equalsIgnoreCase("-")) {
                num = 0;
                slashNb = 0;
                time = 0;
                notarabic = 0;
                int length = array[j].length();
                StringBuilder value = new StringBuilder();
                String preValue = "";
                int counter = 0;
                for (char ch : array[j].toCharArray()) {
                    counter++;
                    if (String.valueOf(ch) != null && !String.valueOf(ch).equalsIgnoreCase("")) {
                        if (!String.valueOf(ch).equalsIgnoreCase(" ")) {
                            int i = Integer.valueOf(mapping(String.valueOf(ch), counter, preValue, length));
                            if (i == 0) {
                                value.append(ch);
                                if (String.valueOf(ch).equalsIgnoreCase("/")) {
                                    slashNb++;
                                }

                                if (String.valueOf(ch).equalsIgnoreCase(":")) {
                                    time++;
                                }
                            } else
                                value = value.append(Character.toString((char) i));

                        } else
                            value = value.append(" ");
                        preValue = String.valueOf(ch);
                    }
                }
                // value = new StringBuilder(value1);
                StringBuffer stringBuffer = new StringBuffer(value);
//                    if(value.toString().contains())
                if (num < length && slashNb != 2)
                    if (time != 1 && notarabic != length)
                        value.reverse().toString();

                if (j == array.length - 1)
                    finalWord = finalWord + value;
                else
                    finalWord = finalWord + value + " ";


//                }
//                else
//                {
//                    finalWord = finalWord+"-";
//                }
            }

            String[] rev = spliString(finalWord, false);

            finalWord = "";
            for (int i = rev.length - 1; i > -1; i--)
                finalWord = finalWord + rev[i] + " ";

        } catch (Exception e) {
            e.printStackTrace();
        }
        finalWord = finalWord.replaceAll("-  -", "--");
        finalWord = finalWord.replaceAll(" - ", "-");

        return finalWord;
    }

    public static String mapping(String charac, Integer counter, String preValue, int length) {
        String val = "0";

        if (charac.equalsIgnoreCase("لأ")) {
            if (counter == 1 && counter != length)
                val = "153";
            else if (disconnectedLetters(preValue))
                val = "153";
            else
                val = "154";
            return val;
        }
        if (charac.equalsIgnoreCase("لا")) {
            if (counter == 1 && counter != length)
                val = "157";
            else if (disconnectedLetters(preValue))
                val = "157";
            else
                val = "158";

            return val;
        }
        if (charac.equalsIgnoreCase("أ")) {

            if (counter == 1 && counter != length)
                val = "195";
            else if (disconnectedLetters(preValue))
                val = "195";
            else
                val = "158";
            return val;
        }

        /*if(charac.equalsIgnoreCase("×")){

            if(counter ==1 &&  counter != length)
                val = "222";
            else
            if(disconnectedLetters(preValue))
                val = "222";
            else
                val = "222";
            return val ; }*/

        if (charac.equalsIgnoreCase("ا") || charac.equalsIgnoreCase("إ")) {
            if (counter == 1 && counter != length)
                val = "199";
            else if (disconnectedLetters(preValue))
                val = "199";
            else
                val = "168";
            return val;
        }
        if (charac.equalsIgnoreCase("ب")) {
            if (counter == 1 && counter != length) {
                val = "200";
            } else if (!disconnectedLetters(preValue) && counter < length) {
                val = "200";
            } else if (disconnectedLetters(preValue) && counter < length) {
                val = "200";
            } else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "167";
            else {
                val = "169";
            }
            return val;
        }
        if (charac.equalsIgnoreCase("ت")) {

            if (counter == 1 && counter != length) {
                val = "202";
            } else if (!disconnectedLetters(preValue) && counter < length) {
                val = "202";
            } else if (disconnectedLetters(preValue) && counter < length) {
                val = "202";
            } else if (/*disconnectedLetters(preValue) &&*/ counter < length) {
                val = "164";
            } else
                val = "170";

            return val;
        }
        if (charac.equalsIgnoreCase("ث")) {
            if (counter == 1 && counter != length)
                val = "203";
            else if (/*disconnectedLetters(preValue) && */counter < length)
                val = "203";
            else
                val = "171";
            return val;
        }
        if (charac.equalsIgnoreCase("،")) {
            val = "172";
            return val;
        }
        if (charac.equalsIgnoreCase("ج")) {

            if (counter == 1 && counter != length) {
                val = "204";
            } else if (!disconnectedLetters(preValue) && counter < length) {
                val = "204";
            } else if (disconnectedLetters(preValue) && counter < length) {
                val = "204";
            } else if (/*disconnectedLetters(preValue) &&*/ counter < length) {
                val = "204";
            } else {
                val = "172";
            }
            return val;
        }
        if (charac.equalsIgnoreCase("ح")) {
            if (counter == 1 && counter != length)
                val = "205";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "205";
            else
                val = "174";
            return val;
        }
        if (charac.equalsIgnoreCase("خ")) {
            if (counter == 1 && counter != length) {
                val = "206";
            } else if (!disconnectedLetters(preValue) && counter < length) {
                val = "206";
            } else if (disconnectedLetters(preValue) && counter < length) {
                val = "124";
            } else if (/*disconnectedLetters(preValue) &&*/ counter < length) {
                val = "206";
            } else {
                val = "175";
            }
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("0")) {
            val = "176";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("1")) {
            val = "177";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("2")) {
            val = "178";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("3")) {
            val = "179";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("4")) {
            val = "180";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("5")) {
            val = "181";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("6")) {
            val = "182";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("7")) {
            val = "183";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("8")) {
            val = "184";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("?") || charac.equalsIgnoreCase("9")) {
            val = "185";
            num++;
            return val;
        }
        if (charac.equalsIgnoreCase("ف")) {
            if (counter == 1 && counter != length)
                val = "225";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "225";
            else
                val = "186";
            return val;
        }
    /*    if(charac.equalsIgnoreCase(":")){
            val = "187";
            return val ; }*/
        if (charac.equalsIgnoreCase("س")) {
            if (counter == 1 && counter != length)
                val = "211";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "211";
            else
                val = "188";
            return val;
        }
        if (charac.equalsIgnoreCase("ش")) {
            if (counter == 1 && counter != length)
                val = "212";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "212";
            else
                val = "189";
            return val;
        }
        if (charac.equalsIgnoreCase("ص")) {
            if (counter == 1 && counter != length)
                val = "213";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "213";
            else
                val = "190";
            return val;
        }
        /*if (charac.equalsIgnoreCase("؟")) {
            val = "191";
            return val;
        }*/
        if (charac.equalsIgnoreCase("¢")) {
            val = "192";
            return val;
        }
        if (charac.equalsIgnoreCase("ء")) {
            val = "193";
            return val;
        }
        if (charac.equalsIgnoreCase("آ")) {
            val = "194";
            return val;
        }
        if (charac.equalsIgnoreCase("ؤ")) {
            val = "196";
            return val;
        }
        if (charac.equalsIgnoreCase("ع")) {
            if (counter == 1 && counter != length)
                val = "217";
            else if (disconnectedLetters(preValue) && counter < length)
                val = "217";
            else if (counter < length)
                val = "236";
            else if (disconnectedLetters(preValue) && counter == length)
                val = "223";
            else
                val = "197";
            return val;
        }

        if (charac.equalsIgnoreCase("ة")) {

            if (!disconnectedLetters(preValue) && counter == length) {
                val = "191";
            } else {
                val = "201";
            }

            return val;
        }
        if (charac.equalsIgnoreCase("د")) {
            //val = "207";

            if (counter == 1 && counter != length)
                val = "207";
            else if (!disconnectedLetters(preValue) && counter < length)
                val = "123";
            else
                val = "207";

            return val;
        }
        if (charac.equalsIgnoreCase("?")) {
            //val = "208";

            if (counter == 1 && counter != length)
                val = "208";
            else if (!disconnectedLetters(preValue) && counter < length)
                val = "219";
            else
                val = "208";

            return val;
        }
        if (charac.equalsIgnoreCase("ر")) {
            //val = "209";

            if (counter == 1 && counter != length)
                val = "209";
            else if (!disconnectedLetters(preValue) && counter < length)
                val = "125";
            else
                val = "209";

            return val;
        }
        if (charac.equalsIgnoreCase("ز")) {
            //val = "210";

            if (counter == 1 && counter != length)
                val = "210";
            else if (!disconnectedLetters(preValue) && counter < length)
                val = "126";
            else
                val = "210";

            return val;
        }
        if (charac.equalsIgnoreCase("ض")) {
            if (counter == 1 && counter != length)
                val = "214";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "214";
            else
                val = "235";
            return val;
        }
        if (charac.equalsIgnoreCase("ط")) {
            val = "215";

            return val;
        }
        if (charac.equalsIgnoreCase("ظ")) {
            val = "216";
            return val;
        }

        if (charac.equalsIgnoreCase("¦")) {
            val = "219";
            return val;
        }
        if (charac.equalsIgnoreCase("¬")) {
            val = "220";
            return val;
        }
        if (charac.equalsIgnoreCase("÷")) {
            val = "221";
            return val;
        }
        if (charac.equalsIgnoreCase("×")) {
            val = "222";
            return val;
        }
        if (charac.equalsIgnoreCase("ـ")) {
            val = "224";
            return val;
        }
        if (charac.equalsIgnoreCase("ق")) {
            val = "226";
            if (counter == 1 && counter != length)
                val = "226";
            else if (disconnectedLetters(preValue) && counter < length)
                val = "226";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "226";
            else
                val = "248";
            return val;
        }

        if (charac.equalsIgnoreCase("و")) {
            //val = "232";

            if (counter == 1 && counter != length)
                val = "232";
            else if (!disconnectedLetters(preValue) && counter < length)
                val = "162";
            else
                val = "232";

            return val;
        }
        if (charac.equalsIgnoreCase("ى") || charac.equalsIgnoreCase("ئ")) {
            val = "233";
            if (counter == 1 && counter != length)
                val = "198";
            else if (counter < length)
                val = "198";
            else if (/*disconnectedLetters(preValue) && */counter == length)
                val = "233";
            else
                val = "245";
            return val;
        }
        if (charac.equalsIgnoreCase("غ")) {
            if (counter == 1 && counter != length)
                val = "218";
            else if (disconnectedLetters(preValue) && counter < length)
                val = "218";
            else if (counter < length)
                val = "247";
            else if (disconnectedLetters(preValue) && counter == length)
                val = "238";
            else
                val = "237";
            return val;
        }
        if (charac.equalsIgnoreCase("م")) {
            if (counter == 1 && counter != length)
                val = "229";
            else if (counter < length)
                val = "166";
            else
                val = "239";
            return val;
        }
        if (charac.equalsIgnoreCase("?")) {
            val = "240";
            return val;
        }
        if (charac.equalsIgnoreCase("_ّ")) {
            val = "241";
            return val;
        }

        if (charac.equalsIgnoreCase("ن")) {
            if (counter == 1 && counter != length)
                val = "230";
//            else
//            if(disconnectedLetters(preValue) && counter < length )
//                val = "229";
            else if (counter < length)
                val = "230";
            else
                val = "242";
            return val;
        }

        if (charac.equalsIgnoreCase("ه")) {
            val = "243";
            if (counter == 1 && counter != length)
                val = "231";
            else if (disconnectedLetters(preValue) && counter < length)
                val = "231";
            else if (counter < length)
                val = "244";
            else if (disconnectedLetters(preValue) && counter == length)
                val = "243";
            else
                val = "243";

            return val;
        }


        if (charac.equalsIgnoreCase("?")) {
            val = "249";
            if (counter == 1 && counter != length)
                val = "249";
            else if (disconnectedLetters(preValue))
                val = "249";
            else
                val = "250";
            return val;
        }
        if (charac.equalsIgnoreCase("ل")) {
            if (counter == 1 && counter != length)
                val = "228";
            else if (disconnectedLetters(preValue) && counter < length)
                val = "228";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "163";
            else
                val = "251";
            return val;
        }
        if (charac.equalsIgnoreCase("ك")) {
            if (counter == 1 && counter != length)
                val = "227";
            else if (/*disconnectedLetters(preValue) &&*/ counter < length)
                val = "227";
            else
                val = "252";
            return val;
        }
        if (charac.equalsIgnoreCase("ي")) {
            val = "253";
            if (counter == 1 && counter != length) {
                val = "234";
            } else if (disconnectedLetters(preValue) && counter == length) {
                val = "253";

            } else if (disconnectedLetters(preValue) && counter < length) {
                val = "234";

            } else if (!disconnectedLetters(preValue) && counter < length) {
                val = "165";

            } else if (counter == length)
                val = "246";

            return val;
        }
        if (charac.equalsIgnoreCase("?")) {
            val = "254";
            return val;
        } else if (val.equalsIgnoreCase("0"))
            notarabic++;
        num++;
        return val;
    }

    public static boolean disconnectedLetters(String c) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("أ", "ا", "ا", "?",
                "ؤ", "د", "?", "ر",
                "?", "ز", "و", "×"));
        if (arrayList.contains(c))
            return true;
        return false;
    }

    public static String[] spliString(String word, boolean dash) {
        String[] array;

        if (dash) {
            String word1 = word.replaceAll("-", " - ");
            array = word1.split(" ");

            return array;
        } else {
            array = word.split(" ");
            return array;
        }
    }
//    public static String isdate(String date)
//    {
//        for(char ch)
//    }
}
