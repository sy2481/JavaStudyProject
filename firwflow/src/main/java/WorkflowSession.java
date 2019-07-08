/**
 * @Author sunyi
 * @Date: 2019/1/30
 */
import org.fireflow.engine.IProcessInstance;
import org.fireflow.engine.IWorkItem;
import org.fireflow.engine.IWorkflowSession;
public class WorkflowSession {
    private String sessionId;
    private IWorkflowSession workflowSession;
    private IProcessInstance processInstance;
    private IWorkItem workItem;
}
