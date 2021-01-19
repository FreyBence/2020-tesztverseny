package hu.testathon.model;

import hu.testathon.controller.TestService;
import hu.testathon.model.domain.TestValidator;
import hu.testathon.model.service.*;

import java.util.Scanner;

public class App {

    private final TestService testService;
    private final Console console;
    private final FileWriter fileWriter;

    private App() {
        console = new Console(new Scanner(System.in));
        fileWriter = new FileWriter("pontok.txt");
        DataApi dataApi = new DataApi("valaszok.txt",
                new FileReader(), new DataParser());
        testService = new TestService(new TestValidator(dataApi.getAnswers()),
                dataApi.getTestResults());
    }
    public static void  main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat: Az adatok beolvasása");
        System.out.println();
        System.out.println("2. feladat: A vetélkedőn "
                + testService.getCompetitorsCount() + " versenyző indult.");
        System.out.println();
        System.out.print("3. feladat: A versenyző azonosítója = ");
        String id = console.read();
        System.out.println(testService.getAnswersById(id)
                + "\t(a versenyző válasza)");
        System.out.println();
        System.out.println("4. feladat: ");
        System.out.println(testService.getCheckedResult(id));
        System.out.print("5. feladat: A feladat sorszáma = ");
        int taskNumber = console.readInt();
        System.out.println(testService.getCorrectAnswerStatistic(taskNumber));
        System.out.println();
        System.out.println("6. feladat: A versenyzők pontszámának meghatározása");
        fileWriter.printAll(testService.getScores());
        System.out.println();
        System.out.println("7. feladat: A verseny legjobbjai: ");
        System.out.println(testService.getOrderResult());
    }
}
