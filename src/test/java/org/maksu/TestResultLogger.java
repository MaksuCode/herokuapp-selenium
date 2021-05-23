package org.maksu;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.util.Optional;

public class TestResultLogger implements TestWatcher {

    Logger logger = new Logger();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.info(getTestName(context).concat(" is disabled with reason : ").concat(reason.get()));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info(getTestName(context).concat(" PASSED..."));
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error(getTestName(context).concat(" FAILED").concat(" , cause : ").concat(cause.getMessage()));
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.warn(getTestName(context).concat(" ABORTED").concat(" , caues : ").concat(cause.getMessage()));
    }

    private String getTestName(ExtensionContext context){
        String className = context.getRequiredTestClass().getSimpleName();
        String methodName = context.getDisplayName().toLowerCase();
        return className.concat(".").concat(methodName);

    }
}
