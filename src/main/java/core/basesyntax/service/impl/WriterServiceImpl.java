package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String report, String pathToReportFile) {
        Path path = Paths.get(pathToReportFile);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException("File can't be created.", e);
        }

        try {
            Files.write(path, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("It is impossible to write to file "
                                        + pathToReportFile, e);
        }
    }
}
