package cc.yyf.window;

import cc.yyf.data.DataCenter;
import cc.yyf.procesor.DefaultSourceNoteData;
import cc.yyf.procesor.MDFreeMarkProcessor;
import cc.yyf.procesor.Processor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import freemarker.template.TemplateException;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class NoteListWindow {
    private JTextField textFieldTopic;
    private JTable table;
    private JButton makeNoteButton;
    private JButton cancelNoteButton;
    private JButton closeButton;
    private JPanel contentPanel;

    public JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     * 初始化方法
     */
    private void init() {
        // 设置表格
        table.setModel(DataCenter.TABLE_MODEL);
        table.setEnabled(true);
    }


    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        makeNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String topicText = textFieldTopic.getText();
                String fileName = topicText + ".md";
                if (topicText == null || "".equals(topicText)) {
                    MessageDialogBuilder.yesNo("操作结果", "文档标题没有输入");
                    return;
                }
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getBaseDir());
                if (virtualFile != null) {
                    String path = virtualFile.getPath();
                    String fileFullPath = path + File.separator + fileName;
                    Processor processor = new MDFreeMarkProcessor();
                    try {
                        processor.process(new DefaultSourceNoteData(fileFullPath, topicText, DataCenter.NOTE_LIST));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (TemplateException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        cancelNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataCenter.reset();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolWindow.hide(null);
            }
        });
    }
}
