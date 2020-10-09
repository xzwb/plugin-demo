package cc.yyf.action;

import cc.yyf.data.DataCenter;
import cc.yyf.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        // 获取选择的文本
        String selectedText = selectionModel.getSelectedText();
        DataCenter.SELECT_TEXT = selectedText;
        // 获取被选择字段所在文件的文件名
        String fileName = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.FILE_NAME = fileName;

        AddNoteDialog noteDialog = new AddNoteDialog();
        noteDialog.show();
    }
}
