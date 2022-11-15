package renfe.com.validator;

import java.util.List;

public class ValidationResult {

    private boolean ok;
    private List errors;

    public ValidationResult(boolean ok, List errors) {

        this.ok = ok;
        this.errors = errors;
    }

    public List getErrors() {
        return errors;
    }

    public boolean isOk() {
        return ok;
    }
}
