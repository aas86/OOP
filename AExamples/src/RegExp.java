import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        //String string = "the text is //multiline /*comment text*/";

        String string = "Петров|600|seconds";

        Pattern pattern = Pattern.compile("^(.*?\\|)(.*?)(\\|.*)");
        Matcher matcher = pattern.matcher(string);
        matcher.find();
        String str = matcher.group(2);
        int time = Integer.parseInt(str);
        System.out.println(time);
      /*  if (matcher.find()) {
         //   str[0] = matcher.group(0);
            str[1] = matcher.group(1);
            str[2] = matcher.group(2);
            str[3] = matcher.group(3);
          //  str[4] = matcher.group(4);
           // str[5] = matcher.group(5);
        }
        System.out.println(Arrays.toString(str));*/
    }
}

