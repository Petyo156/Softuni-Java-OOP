package _5_TelephonyTry2;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url:this.urls) {
            if(url.matches("[^0-9]+")) {
                stringBuilder.append("Browsing: ").append(url).append("!\n");
            } else {
                stringBuilder.append("Invalid URL!" + "\n");
            }
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number:this.numbers) {
            if(number.matches("[0-9]+")) {
                stringBuilder.append("Calling... ").append(number).append("\n");
            } else {
                stringBuilder.append("Invalid number!" + "\n");
            }
        }
        return stringBuilder.toString().trim();
    }

}
