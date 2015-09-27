package org.netbeans.ts;

import java.util.logging.Logger;
import javax.swing.text.Document;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
//import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
//import org.netbeans.modules.csl.api.DataLoadersBridge;
//import org.netbeans.modules.css.prep.util.CssPreprocessorUtils;
import org.netbeans.spi.editor.document.OnSaveTask;
//import org.openide.filesystems.FileObject;
import org.openide.util.RequestProcessor;

@MimeRegistrations({
    @MimeRegistration(mimeType = "text/x-ts", service = OnSaveTask.Factory.class, position = 2000),})
public class JSOnSaveHook implements OnSaveTask.Factory {

    private static final RequestProcessor RP = new RequestProcessor(JSOnSaveHook.class);
    private static final Logger LOG = Logger.getLogger(JSOnSaveHook.class.getSimpleName());
    
    @Override
    public OnSaveTask createTask(OnSaveTask.Context context) {
        Document doc = context.getDocument();
//        final FileObject fileObject = DataLoadersBridge.getDefault().getFileObject(doc);
//        final Project project = fileObject == null ? null : FileOwnerQuery.getOwner(fileObject);
        final Project project = null;
        return project == null ? null : new OnSaveTask() {
            private boolean cancelled;

            @Override
            public void performTask() {
                if (!cancelled) {
                    //run the CssPreprocessorUtils.processSavedFile() out of the original thread
                    RP.post(new Runnable() {

                        @Override
                        public void run() {
//                            String mimeType = fileObject.getMIMEType();
//                            CssPreprocessorType type = CssPreprocessorType.find(mimeType);
//                            if (type == null) {
//                                // #244470
//                                LOG.log(Level.WARNING, "Cannot find CssPreprocessorType for MIME type {0} (filename: {1})", new Object[] {mimeType, fileObject.getNameExt()});
//                                return;
//                            }
//                            CssPreprocessorUtils.processSavedFile(project, type);
//                            LOG.log(Level.INFO, "processSavedFile called for {0} type on project {1}.", new Object[]{type.getDisplayName(), project.getProjectDirectory().getPath()});
                        }
                        
                    });
                }
            }

            @Override
            public void runLocked(Runnable run) {
                run.run(); //better keep running in the original thread as the tasks may be nested
            }

            @Override
            public boolean cancel() {
                return cancelled = true;
            }
        };
    }
}
