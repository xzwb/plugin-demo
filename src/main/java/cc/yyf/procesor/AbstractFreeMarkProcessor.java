package cc.yyf.procesor;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public abstract class AbstractFreeMarkProcessor implements Processor {
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    protected abstract Template getTemplate() throws IOException;

    protected abstract Writer getWrite(SourceNoteData sourceNoteData) throws FileNotFoundException, UnsupportedEncodingException;

    @Override
    public final void process(SourceNoteData sourceNoteData) throws IOException, TemplateException {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer write = getWrite(sourceNoteData);
        template.process(model, write);
    }
}
