package org.netbeans.ts;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.text.Document;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.document.OnSaveTask;
import org.netbeans.ts.options.TypeScriptOptionsPanel;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.util.NbPreferences;

public class JSOnSaveHook implements OnSaveTask {

    private final Document document;

    private final AtomicBoolean canceled = new AtomicBoolean();

    public JSOnSaveHook(Document doc) {
        this.document = doc;
    }

    @Override
    public void performTask() {
        StatusDisplayer.getDefault().setStatusText("Transpile to TypeScript...",10);
        String tsc = NbPreferences.forModule(TypeScriptOptionsPanel.class).get("tsc", "");
        execute(tsc, getFileObject(document));
    }

    public FileObject getFileObject(Document doc) {
        Object sdp = doc.getProperty(Document.StreamDescriptionProperty);
        if (sdp instanceof FileObject) {
            return (FileObject) sdp;
        }
        if (sdp instanceof DataObject) {
            return ((DataObject) sdp).getPrimaryFile();
        }
        return null;
    }

    public Integer execute(final String path, FileObject fo) {
        Integer get = null;
//        ExecutionDescriptor descriptor = new ExecutionDescriptor().
//                showProgress(true).
//                frontWindow(true).
//                controllable(true);
//        ExternalProcessBuilder processBuilder = new ExternalProcessBuilder(path)
//                .addArgument("-o").addArgument(fo.getParent().getPath() + "/" + fo.getName() + ".dart.js")
//                .addArgument("--minify")
//                .addArgument(fo.getPath());
//        ExecutionService service = ExecutionService.newService(processBuilder, descriptor, path);
//        Future<Integer> task = service.run();
//        try {
//            get = task.get();
//        } catch (InterruptedException ex) {
//            Exceptions.printStackTrace(ex);
//        } catch (ExecutionException ex) {
//            Exceptions.printStackTrace(ex);
//        }
        return get;
    }

    @Override
    public void runLocked(Runnable r) {
        r.run();
    }

    @Override
    public boolean cancel() {
        canceled.set(true);
        return true;
    }

    @MimeRegistration(mimeType = "text/x-ts", service = OnSaveTask.Factory.class, position = 1500)
    public static final class FactoryImpl implements Factory {
        @Override
        public OnSaveTask createTask(Context context) {
            return new JSOnSaveHook(context.getDocument());
        }
    }

}
