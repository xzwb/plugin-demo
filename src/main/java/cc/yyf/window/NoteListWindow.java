package cc.yyf.window;

import cc.yyf.data.DataCenter;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            }
        });
        cancelNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
