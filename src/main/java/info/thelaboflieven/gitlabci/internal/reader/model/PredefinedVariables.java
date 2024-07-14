package info.thelaboflieven.gitlabci.internal.reader.model;

/**
 * More details here: https://docs.gitlab.com/ee/ci/variables/predefined_variables.html
 */
public class PredefinedVariables {
    public static Variable CHAT_CHANNEL(String value) {
        return new Variable("CHAT_CHANNEL", value);
    }

    public static Variable CHAT_INPUT(String value) {
        return new Variable("CHAT_INPUT", value);
    }

    public static Variable CHAT_USER_ID(String value) {
        return new Variable("CHAT_USER_ID", value);
    }

    public static Variable CI(String value) {
        return new Variable("CI", value);
    }

    public static Variable CI_API_V4_URL(String value) {
        return new Variable("CI_API_V4_URL", value);
    }

    public static Variable CI_API_GRAPHQL_URL(String value) {
        return new Variable("CI_API_GRAPHQL_URL", value);
    }

    public static Variable CI_BUILDS_DIR(String value) {
        return new Variable("CI_BUILDS_DIR", value);
    }

    public static Variable CI_COMMIT_AUTHOR(String value) {
        return new Variable("CI_COMMIT_AUTHOR", value);
    }

    public static Variable CI_COMMIT_BEFORE_SHA(String value) {
        return new Variable("CI_COMMIT_BEFORE_SHA", value);
    }

    public static Variable CI_COMMIT_BRANCH(String value) {
        return new Variable("CI_COMMIT_BRANCH", value);
    }

    public static Variable CI_COMMIT_DESCRIPTION(String value) {
        return new Variable("CI_COMMIT_DESCRIPTION", value);
    }

    public static Variable CI_COMMIT_MESSAGE(String value) {
        return new Variable("CI_COMMIT_MESSAGE", value);
    }

    public static Variable CI_COMMIT_REF_NAME(String value) {
        return new Variable("CI_COMMIT_REF_NAME", value);
    }

    public static Variable CI_COMMIT_REF_PROTECTED(String value) {
        return new Variable("CI_COMMIT_REF_PROTECTED", value);
    }

    public static Variable CI_COMMIT_REF_SLUG(String value) {
        return new Variable("CI_COMMIT_REF_SLUG", value);
    }

    public static Variable CI_COMMIT_SHA(String value) {
        return new Variable("CI_COMMIT_SHA", value);
    }

    public static Variable CI_COMMIT_SHORT_SHA(String value) {
        return new Variable("CI_COMMIT_SHORT_SHA", value);
    }

    public static Variable CI_COMMIT_TAG(String value) {
        return new Variable("CI_COMMIT_TAG", value);
    }

    public static Variable CI_COMMIT_TAG_MESSAGE(String value) {
        return new Variable("CI_COMMIT_TAG_MESSAGE", value);
    }

    public static Variable CI_COMMIT_TIMESTAMP(String value) {
        return new Variable("CI_COMMIT_TIMESTAMP", value);
    }

    public static Variable CI_COMMIT_TITLE(String value) {
        return new Variable("CI_COMMIT_TITLE", value);
    }

    public static Variable CI_CONCURRENT_ID(String value) {
        return new Variable("CI_CONCURRENT_ID", value);
    }

    public static Variable CI_CONCURRENT_PROJECT_ID(String value) {
        return new Variable("CI_CONCURRENT_PROJECT_ID", value);
    }

    public static Variable CI_CONFIG_PATH(String value) {
        return new Variable("CI_CONFIG_PATH", value);
    }

    public static Variable CI_DEBUG_TRACE(String value) {
        return new Variable("CI_DEBUG_TRACE", value);
    }

    public static Variable CI_DEBUG_SERVICES(String value) {
        return new Variable("CI_DEBUG_SERVICES", value);
    }

    public static Variable CI_DEFAULT_BRANCH(String value) {
        return new Variable("CI_DEFAULT_BRANCH", value);
    }

    public static Variable CI_DEPENDENCY_PROXY_DIRECT_GROUP_IMAGE_PREFIX(String value) {
        return new Variable("CI_DEPENDENCY_PROXY_DIRECT_GROUP_IMAGE_PREFIX", value);
    }

    public static Variable CI_DEPENDENCY_PROXY_GROUP_IMAGE_PREFIX(String value) {
        return new Variable("CI_DEPENDENCY_PROXY_GROUP_IMAGE_PREFIX", value);
    }

    public static Variable CI_DEPENDENCY_PROXY_PASSWORD(String value) {
        return new Variable("CI_DEPENDENCY_PROXY_PASSWORD", value);
    }

    public static Variable CI_DEPENDENCY_PROXY_SERVER(String value) {
        return new Variable("CI_DEPENDENCY_PROXY_SERVER", value);
    }

    public static Variable CI_DEPENDENCY_PROXY_USER(String value) {
        return new Variable("CI_DEPENDENCY_PROXY_USER", value);
    }

    public static Variable CI_DEPLOY_FREEZE(String value) {
        return new Variable("CI_DEPLOY_FREEZE", value);
    }

    public static Variable CI_DEPLOY_PASSWORD(String value) {
        return new Variable("CI_DEPLOY_PASSWORD", value);
    }

    public static Variable CI_DEPLOY_USER(String value) {
        return new Variable("CI_DEPLOY_USER", value);
    }

    public static Variable CI_DISPOSABLE_ENVIRONMENT(String value) {
        return new Variable("CI_DISPOSABLE_ENVIRONMENT", value);
    }

    public static Variable CI_ENVIRONMENT_NAME(String value) {
        return new Variable("CI_ENVIRONMENT_NAME", value);
    }

    public static Variable CI_ENVIRONMENT_SLUG(String value) {
        return new Variable("CI_ENVIRONMENT_SLUG", value);
    }

    public static Variable CI_ENVIRONMENT_URL(String value) {
        return new Variable("CI_ENVIRONMENT_URL", value);
    }

    public static Variable CI_ENVIRONMENT_ACTION(String value) {
        return new Variable("CI_ENVIRONMENT_ACTION", value);
    }

    public static Variable CI_ENVIRONMENT_TIER(String value) {
        return new Variable("CI_ENVIRONMENT_TIER", value);
    }

    public static Variable CI_GITLAB_FIPS_MODE(String value) {
        return new Variable("CI_GITLAB_FIPS_MODE", value);
    }

    public static Variable CI_HAS_OPEN_REQUIREMENTS(String value) {
        return new Variable("CI_HAS_OPEN_REQUIREMENTS", value);
    }

    public static Variable CI_JOB_ID(String value) {
        return new Variable("CI_JOB_ID", value);
    }

    public static Variable CI_JOB_IMAGE(String value) {
        return new Variable("CI_JOB_IMAGE", value);
    }

    public static Variable CI_JOB_MANUAL(String value) {
        return new Variable("CI_JOB_MANUAL", value);
    }

    public static Variable CI_JOB_NAME(String value) {
        return new Variable("CI_JOB_NAME", value);
    }

    public static Variable CI_JOB_NAME_SLUG(String value) {
        return new Variable("CI_JOB_NAME_SLUG", value);
    }

    public static Variable CI_JOB_STAGE(String value) {
        return new Variable("CI_JOB_STAGE", value);
    }

    public static Variable CI_JOB_STATUS(String value) {
        return new Variable("CI_JOB_STATUS", value);
    }

    public static Variable CI_JOB_TIMEOUT(String value) {
        return new Variable("CI_JOB_TIMEOUT", value);
    }

    public static Variable CI_JOB_TOKEN(String value) {
        return new Variable("CI_JOB_TOKEN", value);
    }

    public static Variable CI_JOB_URL(String value) {
        return new Variable("CI_JOB_URL", value);
    }

    public static Variable CI_JOB_STARTED_AT(String value) {
        return new Variable("CI_JOB_STARTED_AT", value);
    }

    public static Variable CI_KUBERNETES_ACTIVE(String value) {
        return new Variable("CI_KUBERNETES_ACTIVE", value);
    }

    public static Variable CI_NODE_INDEX(String value) {
        return new Variable("CI_NODE_INDEX", value);
    }

    public static Variable CI_NODE_TOTAL(String value) {
        return new Variable("CI_NODE_TOTAL", value);
    }

    public static Variable CI_OPEN_MERGE_REQUESTS(String value) {
        return new Variable("CI_OPEN_MERGE_REQUESTS", value);
    }

    public static Variable CI_PAGES_DOMAIN(String value) {
        return new Variable("CI_PAGES_DOMAIN", value);
    }

    public static Variable CI_PAGES_URL(String value) {
        return new Variable("CI_PAGES_URL", value);
    }

    public static Variable CI_PIPELINE_ID(String value) {
        return new Variable("CI_PIPELINE_ID", value);
    }

    public static Variable CI_PIPELINE_IID(String value) {
        return new Variable("CI_PIPELINE_IID", value);
    }

    public static Variable CI_PIPELINE_SOURCE(String value) {
        return new Variable("CI_PIPELINE_SOURCE", value);
    }

    public static Variable CI_PIPELINE_TRIGGERED(String value) {
        return new Variable("CI_PIPELINE_TRIGGERED", value);
    }

    public static Variable CI_PIPELINE_URL(String value) {
        return new Variable("CI_PIPELINE_URL", value);
    }

    public static Variable CI_PIPELINE_CREATED_AT(String value) {
        return new Variable("CI_PIPELINE_CREATED_AT", value);
    }

    public static Variable CI_PIPELINE_NAME(String value) {
        return new Variable("CI_PIPELINE_NAME", value);
    }

    public static Variable CI_PROJECT_DIR(String value) {
        return new Variable("CI_PROJECT_DIR", value);
    }

    public static Variable CI_PROJECT_ID(String value) {
        return new Variable("CI_PROJECT_ID", value);
    }

    public static Variable CI_PROJECT_NAME(String value) {
        return new Variable("CI_PROJECT_NAME", value);
    }

    public static Variable CI_PROJECT_NAMESPACE(String value) {
        return new Variable("CI_PROJECT_NAMESPACE", value);
    }

    public static Variable CI_PROJECT_NAMESPACE_ID(String value) {
        return new Variable("CI_PROJECT_NAMESPACE_ID", value);
    }

    public static Variable CI_PROJECT_PATH_SLUG(String value) {
        return new Variable("CI_PROJECT_PATH_SLUG", value);
    }

    public static Variable CI_PROJECT_PATH(String value) {
        return new Variable("CI_PROJECT_PATH", value);
    }

    public static Variable CI_PROJECT_REPOSITORY_LANGUAGES(String value) {
        return new Variable("CI_PROJECT_REPOSITORY_LANGUAGES", value);
    }

    public static Variable CI_PROJECT_ROOT_NAMESPACE(String value) {
        return new Variable("CI_PROJECT_ROOT_NAMESPACE", value);
    }

    public static Variable CI_PROJECT_TITLE(String value) {
        return new Variable("CI_PROJECT_TITLE", value);
    }

    public static Variable CI_PROJECT_DESCRIPTION(String value) {
        return new Variable("CI_PROJECT_DESCRIPTION", value);
    }

    public static Variable CI_PROJECT_URL(String value) {
        return new Variable("CI_PROJECT_URL", value);
    }

    public static Variable CI_PROJECT_VISIBILITY(String value) {
        return new Variable("CI_PROJECT_VISIBILITY", value);
    }

    public static Variable CI_PROJECT_CLASSIFICATION_LABEL(String value) {
        return new Variable("CI_PROJECT_CLASSIFICATION_LABEL", value);
    }

    public static Variable CI_REGISTRY(String value) {
        return new Variable("CI_REGISTRY", value);
    }

    public static Variable CI_REGISTRY_IMAGE(String value) {
        return new Variable("CI_REGISTRY_IMAGE", value);
    }

    public static Variable CI_REGISTRY_PASSWORD(String value) {
        return new Variable("CI_REGISTRY_PASSWORD", value);
    }

    public static Variable CI_REGISTRY_USER(String value) {
        return new Variable("CI_REGISTRY_USER", value);
    }

    public static Variable CI_RELEASE_DESCRIPTION(String value) {
        return new Variable("CI_RELEASE_DESCRIPTION", value);
    }

    public static Variable CI_REPOSITORY_URL(String value) {
        return new Variable("CI_REPOSITORY_URL", value);
    }

    public static Variable CI_RUNNER_DESCRIPTION(String value) {
        return new Variable("CI_RUNNER_DESCRIPTION", value);
    }

    public static Variable CI_RUNNER_EXECUTABLE_ARCH(String value) {
        return new Variable("CI_RUNNER_EXECUTABLE_ARCH", value);
    }

    public static Variable CI_RUNNER_ID(String value) {
        return new Variable("CI_RUNNER_ID", value);
    }

    public static Variable CI_RUNNER_REVISION(String value) {
        return new Variable("CI_RUNNER_REVISION", value);
    }

    public static Variable CI_RUNNER_SHORT_TOKEN(String value) {
        return new Variable("CI_RUNNER_SHORT_TOKEN", value);
    }

    public static Variable CI_RUNNER_TAGS(String value) {
        return new Variable("CI_RUNNER_TAGS", value);
    }

    public static Variable CI_RUNNER_VERSION(String value) {
        return new Variable("CI_RUNNER_VERSION", value);
    }

    public static Variable CI_SERVER_FQDN(String value) {
        return new Variable("CI_SERVER_FQDN", value);
    }

    public static Variable CI_SERVER_HOST(String value) {
        return new Variable("CI_SERVER_HOST", value);
    }

    public static Variable CI_SERVER_NAME(String value) {
        return new Variable("CI_SERVER_NAME", value);
    }

    public static Variable CI_SERVER_PORT(String value) {
        return new Variable("CI_SERVER_PORT", value);
    }

    public static Variable CI_SERVER_PROTOCOL(String value) {
        return new Variable("CI_SERVER_PROTOCOL", value);
    }

    public static Variable CI_SERVER_SHELL_SSH_HOST(String value) {
        return new Variable("CI_SERVER_SHELL_SSH_HOST", value);
    }

    public static Variable CI_SERVER_SHELL_SSH_PORT(String value) {
        return new Variable("CI_SERVER_SHELL_SSH_PORT", value);
    }

    public static Variable CI_SERVER_REVISION(String value) {
        return new Variable("CI_SERVER_REVISION", value);
    }

    public static Variable CI_SERVER_TLS_CA_FILE(String value) {
        return new Variable("CI_SERVER_TLS_CA_FILE", value);
    }

    public static Variable CI_SERVER_TLS_CERT_FILE(String value) {
        return new Variable("CI_SERVER_TLS_CERT_FILE", value);
    }

    public static Variable CI_SERVER_TLS_KEY_FILE(String value) {
        return new Variable("CI_SERVER_TLS_KEY_FILE", value);
    }

    public static Variable CI_SERVER_URL(String value) {
        return new Variable("CI_SERVER_URL", value);
    }

    public static Variable CI_SERVER_VERSION_MAJOR(String value) {
        return new Variable("CI_SERVER_VERSION_MAJOR", value);
    }

    public static Variable CI_SERVER_VERSION_MINOR(String value) {
        return new Variable("CI_SERVER_VERSION_MINOR", value);
    }

    public static Variable CI_SERVER_VERSION_PATCH(String value) {
        return new Variable("CI_SERVER_VERSION_PATCH", value);
    }

    public static Variable CI_SERVER_VERSION(String value) {
        return new Variable("CI_SERVER_VERSION", value);
    }

    public static Variable CI_SERVER(String value) {
        return new Variable("CI_SERVER", value);
    }

    public static Variable CI_SHARED_ENVIRONMENT(String value) {
        return new Variable("CI_SHARED_ENVIRONMENT", value);
    }

    public static Variable CI_TEMPLATE_REGISTRY_HOST(String value) {
        return new Variable("CI_TEMPLATE_REGISTRY_HOST", value);
    }

    public static Variable CI_TRIGGER_SHORT_TOKEN(String value) {
        return new Variable("CI_TRIGGER_SHORT_TOKEN", value);
    }

    public static Variable GITLAB_CI(String value) {
        return new Variable("GITLAB_CI", value);
    }

    public static Variable GITLAB_FEATURES(String value) {
        return new Variable("GITLAB_FEATURES", value);
    }

    public static Variable GITLAB_USER_EMAIL(String value) {
        return new Variable("GITLAB_USER_EMAIL", value);
    }

    public static Variable GITLAB_USER_ID(String value) {
        return new Variable("GITLAB_USER_ID", value);
    }

    public static Variable GITLAB_USER_LOGIN(String value) {
        return new Variable("GITLAB_USER_LOGIN", value);
    }

    public static Variable GITLAB_USER_NAME(String value) {
        return new Variable("GITLAB_USER_NAME", value);
    }

    public static Variable KUBECONFIG(String value) {
        return new Variable("KUBECONFIG", value);
    }

    public static Variable TRIGGER_PAYLOAD(String value) {
        return new Variable("TRIGGER_PAYLOAD", value);
    }

    public static Variable CI_MERGE_REQUEST_ID(String value) {
        return new Variable("CI_MERGE_REQUEST_ID", value);
    }
}
