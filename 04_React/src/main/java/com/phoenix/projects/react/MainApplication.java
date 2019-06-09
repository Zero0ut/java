package com.phoenix.projects.react;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {

    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) throws IOException {

        LottoApplication app = new LottoApplication();
        logger.info("Started " + MainApplication.class.getName());

        int counter = 1;
        List<int[]> results =  app.generate(49, 6);
        List<int[]> filteredResult = new ArrayList();

        for(int[] result : results) {
            if(!app.filter(result))
                filteredResult.add(result);
        }


        logger.info("Maximum Permutation: " + String.format( "%,d" , results.size()));
        logger.info("Filtered Permutation: " + String.format( "%,d" , filteredResult.size()));

        logger.info("Start writing filtered results to file");
        FileWriter fileWriter = new FileWriter("FilteredResultsX.csv");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int[] result : filteredResult) {
            //printWriter.println(String.format( "%,d" , counter) + ", " + Arrays.toString(result));
            printWriter.println(Arrays.toString(result));
            counter++;
        }
        printWriter.close();
        logger.info("Complete writing filtered results to file");

        BackTestApplication bckTest = new BackTestApplication();
        bckTest.runCheck(filteredResult);
        logger.info("Completed Successfully " + MainApplication.class.getName());

    }
}
