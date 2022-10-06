package com.waruguru;

public class CountFruits {

    public static void main(String[] args) {
        buildResponse(WordAndLetterCounter.startProgram(args.length != 0 ? args : new String[]{"Strawberry", "Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine", "Pineapple", "Lemon", "Plum", "Tangerine", "Fig", "Blueberry", "Grape", "Jackfruit", "Pomegranate", "Apple", "Pear", "Orange", "Watermelon", "Raspberry", "Banana"}).toString());
    }

    public static void buildResponse(String responseBody) {
        StringBuilder json = new StringBuilder();
        String header;
        int code;

        if (!responseBody.contains("Invalid")) {
            code = 200;
            header = "customer-message: Success";
        } else {
            code = 400;
            header = "customer-message: Failed";
        }
        json.append("{\n{\n\"headers\":[\n\"")
                .append(header)
                .append("\"}\n},\n{\"code\":")
                .append(code)
                .append("},\n{\"body\":\"")
                .append(responseBody)
                .append("\"}}");

        System.out.println(json.toString());
    }

}
