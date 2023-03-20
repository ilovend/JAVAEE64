package com.itheima.homework.full;

import java.io.InputStream;
import java.util.*;

/**
 * 疫苗分配
 *
 * @author ilovend
 * @date 2023/03/19
 */
public class VaccineDistribution {

    /**
     * 主方法
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        List<String> names = readNamesFromFile();

        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");

        Queue<String> queue = new LinkedList<>(names);

        Thread t1 = new Thread(new VaccinationTask(queue, window1));
        Thread t2 = new Thread(new VaccinationTask(queue, window2));
        Thread t3 = new Thread(new VaccinationTask(queue, window3));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有小朋友接种完成");
    }

    /**
     * 从文件中读取名字
     *
     * @return {@link List}<{@link String}>
     */
    private static List<String> readNamesFromFile() {
        List<String> names = new ArrayList<>();
        InputStream inputStream = VaccineDistribution.class.getClassLoader().getResourceAsStream("stuName.txt");
        try {
            assert inputStream != null;
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] nameParts = line.split(" ");
                    Collections.addAll(names, nameParts);
                }
            }
        } catch (Exception e) {
            System.err.println("读取文件时发生错误: " + "stuName.txt" + " (" + e.getMessage() + ")");
        }
        return names;
    }
}
