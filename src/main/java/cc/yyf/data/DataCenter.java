package cc.yyf.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    // 选择的文本
    public static String SELECT_TEXT;
    // 文件名称
    public static String FILE_NAME;
    // 笔记的数据
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    // 构建表头
    public static String[] HEAD = {"标题", "备注", "文件名", "代码段"};

    // 数据模型
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null, HEAD);

}
