package _5_Тelephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Browsable, Callable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public Smartphone() {
        this.numbers = new ArrayList<>();
        this.urls = new ArrayList<>();
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void addUrl(String url) {
        this.urls.add(url);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url:this.urls) {
            if(url.matches("[^0-9]+")) {
                stringBuilder.append("Browsing: " + url + "!\n");
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
                stringBuilder.append("Calling... " + number + "\n");
            } else {
                stringBuilder.append("Invalid number!" + "\n");
            }
        }
        return stringBuilder.toString().trim();
    }

}
