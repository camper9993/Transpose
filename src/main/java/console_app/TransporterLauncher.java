package console_app;

import java.io.BufferedWriter;
import java.io.IOException;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class TransporterLauncher {
    @Option(name = "-a", usage = "Максимальная длина слова")
    private int length = -1;

    @Option(name = "-t", usage = "Обрезать слова, длинее -а")
    private boolean clear;

    @Option(name = "-r", usage = "Выравнивать по правому краю?")
    private boolean rightSide;

    @Option(name = "-o", usage = "Имя выходного файла")
    private String outputFileName = "";

    @Argument(usage = "Имя входного файла")
    private String inputFileName = "";

    private TransporterLauncher() {
    }

    public static void main(String[] args) throws IOException {
        new TransporterLauncher().launch(args);
    }


    private void launch(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
            return;
        }

        Transporter f;
        if (!inputFileName.equals(""))
            f = new Transporter(inputFileName);
        else
            f = new Transporter();

        f.transpose();

        if (clear) {
            if (length == -1)
                length = 10;
            f.cut(length);
        }


        if (rightSide) {
            if (length == -1)
                length = 10;
            f.rightSide(length);
        } else
            f.leftSide(length);

        if (!outputFileName.equals(""))
            f.writeToFile(outputFileName);
        else
            f.writeToConsole();
    }
}
