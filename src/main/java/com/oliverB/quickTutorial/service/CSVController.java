package com.oliverB.quickTutorial;

import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CSVController {

    @Bean
    public Object[] readCSVFile(String input_file_name) throws FileNotFoundException, IOException {
        Object[] data_records = null;
        List<List<String>> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(input_file_name));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
            data_records = records.toArray();
        }
        return data_records;
    }

    @Bean
    public void saveCSVFile(String[][] table, String fileName, boolean appending) throws IOException {
        FileWriter writer = null;
        File file = new File(fileName + ".csv");
        // if the file doesn't exist, then set appending to false, as it is making a new file
        if (!file.exists()) {
            appending = false;
        }
        try {
            writer = new FileWriter(file.getAbsolutePath(), appending);
            int j;
            for (int i = 0; i < table.length; i++) {
                for (j = 0; j < table[0].length; j++) {
                    writer.append(table[i][j] + ", ");
                }
                writer.append("\n");
            }
            writer.close();

        } catch (Exception e) {
            throw e;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
    }

}
