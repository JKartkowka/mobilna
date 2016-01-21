package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.util.Pair;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.model.StudentListItem;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.ChangePopQuizForStudentsRequest;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;

/**
 * Created by marian on 31.12.2015.
 */
public class LecturerCustomAuthenticationInteractor extends JKInteractor {
    public final int groupId;
    public final int popQuizId;
    private ArrayList<StudentListItem> fetchedStudenListItems;

    public LecturerCustomAuthenticationInteractor(RequestSender requestSender, Intent intent) {
        super(requestSender);
        groupId = intent.getIntExtra("groupId", -1);
        popQuizId = intent.getIntExtra("popQuizId", -1);
    }

    public void getStudents(final StandardGenericResponseHandler<ArrayList<StudentListItem>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(groupId, new StandardGenericResponseHandler<ArrayList<Student>>() {
            @Override
            public void onSuccess(ArrayList<Student> responseObject) {
                fetchedStudenListItems = mapStudents(responseObject);
                standardGenericResponseHandler.onSuccess(fetchedStudenListItems);
            }
        });
        requestSender.sendRequest(request);
    }

    private ArrayList<StudentListItem> mapStudents(ArrayList<Student> responseObject) {
        ArrayList<StudentListItem> studentListItems = new ArrayList<>();
        for (Student student : responseObject) {
            studentListItems.add(new StudentListItem(student));
        }

        return studentListItems;
    }

    public void activatePopQuiz(StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        ChangePopQuizForStudentsRequest request = new ChangePopQuizForStudentsRequest(mapStudentsIds(), popQuizId, responseHandler);
        requestSender.sendRequest(request);
    }

    private ArrayList<Integer> mapStudentsIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (StudentListItem item : fetchedStudenListItems) {
            if (item.selected) {
                ids.add(item.student.id);
            }
        }

        return ids;
    }
}
