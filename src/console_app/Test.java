package console_app;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //Пример транспонирования и выравнивания по правому краю.
        Transporter f = new Transporter("/Users/Alex/IdeaProjects/Transpose/src/console_app/1");
        /* Исходный текст
        AAA AA FNOasdas
        ass asasdasd
        asdqwd  wekafb  wejweod
        ewwe
        wedwe wdwe
        **/
        f.transpose();
        f.rightSide(8);
        System.out.println(f.convert());
        /* Результат
             AAA      ass   asdqwd     ewwe    wedwe
              AA asasdasd   wekafb     wdwe
        FNOasdas  wejweod


         */

        Transporter g = new Transporter("/Users/Alex/IdeaProjects/Transpose/src/console_app/2");
        //Пример транспонирования без указаний доп фалгов
        /* Исходный текст
        iwnfe qwiodn qwdonq
        qweq qewqe qwe eqweqw eqwe eqeqw e q
        qweqwe eq weq ew q
        **/
        g.transpose();
        g.leftSide(10);
        System.out.println(g.convert());
        /* Результат
        iwnfe    qweq     qweqwe
        qwiodn   qewqe    eq
        qwdonq   qwe      weq
        eqweqw   ew
        eqwe     q
        eqeqw
        e
        q
         */

        Transporter j = new Transporter("/Users/Alex/IdeaProjects/Transpose/src/console_app/3");
        //Пример обрезания слов
        /* Исходный текст
        oin wdod  weof
        ewfwf we fwe f w
        wefwe wef w ef wfe
        **/
        j.transpose();
        j.cut(2);
        System.out.println(j.convert());
        /* Результат
        oi ew we
        wd we we
        we fw w
        f ef
        w wf
         */

        Transporter k = new Transporter("/Users/Alex/IdeaProjects/Transpose/src/console_app/4");
        // Пример всего и сразу
        /* Исходный текст
        welkwe qwoidq dqwd qwod
        qwdqwkd  qdw qwd
        dqwkqdw        dqw d q d q d q
        qwdqwd d wqd q
        **/
        k.transpose();
        k.cut(2);
        k.rightSide(2);
        k.writeTo("TestFile");
        System.out.println(k.convert());
        /* Результат
        we qw dq qw
        qw qd dq  d
        dq qw  d wq
        qw  q  q
         d
         q
         d
         q
         */
    }
}
