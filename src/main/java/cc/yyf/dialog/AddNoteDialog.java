package cc.yyf.dialog;

import cc.yyf.data.DataCenter;
import cc.yyf.data.DataConvert;
import cc.yyf.data.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * 弹出对话框
 */

public class AddNoteDialog extends DialogWrapper {
    private EditorTextField textFieldTitle;
    private EditorTextField textFieldMark;

    public EditorTextField getTextFieldTitle() {
        return textFieldTitle;
    }

    public void setTextFieldTitle(EditorTextField textFieldTitle) {
        this.textFieldTitle = textFieldTitle;
    }

    public EditorTextField getTextFieldMark() {
        return textFieldMark;
    }

    public void setTextFieldMark(EditorTextField textFieldMark) {
        this.textFieldMark = textFieldMark;
    }

    public AddNoteDialog() {
        super(true);
        // 设置标题
        setTitle("添加笔记");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        // 创建面板
        JPanel jPanel = new JPanel(new BorderLayout());
        // 创建输入框
        textFieldTitle = new EditorTextField("笔记的标题");
        textFieldMark = new EditorTextField("笔记的内容");
        // 设置框的大小
        textFieldMark.setPreferredSize(new Dimension(200, 100));
        // 加到面板上
        jPanel.add(textFieldTitle, BorderLayout.NORTH);
        jPanel.add(textFieldMark, BorderLayout.CENTER);
        return jPanel;
    }

    /**
     * 按钮
     * @return
     */
    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton button = new JButton("添加笔记到列表");
        button.addActionListener(e -> {
            // 获取文本
            String title = textFieldTitle.getText();
            String mark = textFieldMark.getText();
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark, DataCenter.SELECT_TEXT, DataCenter.FILE_NAME, fileType);
            DataCenter.NOTE_LIST.add(noteData);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
            MessageDialogBuilder.yesNo("操作结果", "添加成功");
            AddNoteDialog.this.dispose();
        });
        jPanel.add(button);
        return jPanel;
    }
}
