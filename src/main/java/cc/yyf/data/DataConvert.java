package cc.yyf.data;

public class DataConvert {
    public static String[] convert(NoteData data) {
        String[] raw = new String[4];
        raw[0] = data.getTitle();
        raw[1] = data.getMark();
        raw[2] = data.getFileName();
        raw[3] = data.getContent();
        return raw;
    }
}
