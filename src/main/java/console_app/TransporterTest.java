package console_app;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransporterTest {
    @org.junit.jupiter.api.Test
    void transpose() throws IOException{
        StringBuilder sb = new StringBuilder();
        Transporter f = new Transporter("src/main/java/console_app/1");
        f.transpose();
        f.leftSide(8);
        sb.append("AAA      ").append("ass      ").append("asdqwd   ").append("ewwe     ").append("wedwe");
        sb.append("\n");
        sb.append("AA       ").append("asasdasd ").append("wekafb   ").append("wdwe");
        sb.append("\n");
        sb.append("FNOasdas ").append("wejweod");
        sb.append("\n");
        assertEquals(sb.toString(),f.convert());
    }
    @org.junit.jupiter.api.Test
    void rightSide() throws IOException {
        StringBuilder sb = new StringBuilder();
        Transporter f = new Transporter("src/main/java/console_app/2");
        f.transpose();
        f.rightSide(6);
        sb.append(" iwnfe ").append("  qweq ").append("qweqwe");
        sb.append("\n");
        sb.append("qwiodn ").append(" qewqe ").append("    eq");
        sb.append("\n");
        sb.append("qwdonq ").append("   qwe ").append("   weq");
        sb.append("\n");
        assertEquals(sb.toString(),f.convert());
    }
    @org.junit.jupiter.api.Test
    void cut() throws IOException {
        StringBuilder sb = new StringBuilder();
        Transporter f = new Transporter("src/main/java/console_app/3");
        f.transpose();
        f.cut(4);
        f.leftSide(4);
        sb.append("oin  ").append("ewfw ").append("wefw");
        sb.append("\n");
        sb.append("wdod ").append("we   ").append("wef");
        sb.append("\n");
        sb.append("weof ").append("asda ").append("asda");
        sb.append("\n");
        assertEquals(sb.toString(),f.convert());
    }
}