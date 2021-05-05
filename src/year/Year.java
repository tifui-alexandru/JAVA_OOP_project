package year;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Year {
    private Set<String> groupNamesSet = new HashSet<>();
    private List<String> subjects = new ArrayList<>();

    public List<String> getSubjects() {
        return subjects;
    }

    public boolean hasGroup(String groupName) {
        return groupNamesSet.contains(groupName);
    }

    public void addGroup(String name) {
        groupNamesSet.add(name);
    }

    public void addSubject(String subjName) { subjects.add(subjName); }
}
