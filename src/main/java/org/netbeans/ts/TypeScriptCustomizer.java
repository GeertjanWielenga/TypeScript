package org.netbeans.ts;

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.api.project.Project;
import org.netbeans.modules.javascript2.editor.api.FrameworksUtils;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author Petr Pisl
 */
public class TypeScriptCustomizer implements ProjectCustomizer.CompositeCategoryProvider {
@ProjectCustomizer.CompositeCategoryProvider.Registrations({
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
        projectType = FrameworksUtils.HTML5_CLIENT_PROJECT,
        category = FrameworksUtils.CATEGORY,
        position = 270
    ),
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
        projectType = FrameworksUtils.PHP_PROJECT,
        category = FrameworksUtils.CATEGORY,
        position = 270
    ),
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
        projectType = FrameworksUtils.MAVEN_PROJECT,
        category = FrameworksUtils.CATEGORY,
        position = 270
    )   
})
    
    public static TypeScriptCustomizer createCustomizer() {
        return new TypeScriptCustomizer();
    }

    @NbBundle.Messages("TypeScriptCustomizer.displayName=TypeScript")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create(
                "typescript", // NOI18N
                Bundle.TypeScriptCustomizer_displayName(),
                null, (ProjectCustomizer.Category[]) null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        Project project = context.lookup(Project.class);
        return new JPanel();
//        return new RequireJsPanel(category, project);
    }
    
}
