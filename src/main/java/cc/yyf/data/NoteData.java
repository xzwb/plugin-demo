package cc.yyf.data;

/**
 * 笔记的内容
 */
public class NoteData {
    // 标题
    private String title;
    // 笔记内容
    private String mark;
    // 用户选中的内容
    private String content;
    // 文件名
    private String fileName;
    // 文件类型
    private String fileType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public NoteData(String title, String mark, String content, String fileName, String fileType) {
        this.title = title;
        this.mark = mark;
        this.content = content;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "NoteData{" +
                "title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
