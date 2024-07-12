package info.thelaboflieven.gitlabci.reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderCommon {
    public static List<String> flattenList(List<?> mixedList) {
        List<String> resultList = new ArrayList<>();
        for (Object element : mixedList) {
            if (element instanceof String) {
                resultList.add((String) element);
            } else if (element instanceof List) {
                resultList.addAll(flattenList((List<?>) element));
            }
        }
        return resultList;
    }
}
