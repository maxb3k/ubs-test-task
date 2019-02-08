package com.ubs.opsit.interviews;

import org.apache.commons.lang.text.StrBuilder;

public class TimeConverterImpl implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
        String[] strings = aTime.split(":");
        int hours = Integer.valueOf(strings[0]);
        int minutes = Integer.valueOf(strings[1]);
        int seconds = Integer.valueOf(strings[2]);

        return new StrBuilder()
                .appendln(seconds % 2 == 0 ? 'Y' : 'O')
                .appendln(eraseTail("RRRR", hours / 5))
                .appendln(eraseTail("RRRR", hours % 5))
                .appendln(eraseTail("YYRYYRYYRYY", minutes / 5))
                .append(eraseTail("YYYY", minutes % 5)).toString();
    }

    private String eraseTail(String body, int tailStart) {
        return new StringBuilder(body)
                .delete(tailStart, body.length())
                .append("OOOOOOOOOOO")
                .substring(0, body.length());

    }
}
