package cc.yyf.procesor;

import cc.yyf.data.NoteData;

import java.util.List;

public class DefaultSourceNoteData implements SourceNoteData {
    private String fileName;
    private String topic;
    private List<NoteData> noteList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }

    @Override
    public String getTopic() {
        return topic;
    }
}
