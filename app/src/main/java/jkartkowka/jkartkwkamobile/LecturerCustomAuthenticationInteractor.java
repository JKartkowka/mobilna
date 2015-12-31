package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.model.StudentListItem;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;

/**
 * Created by marian on 31.12.2015.
 */
public class LecturerCustomAuthenticationInteractor extends JKInteractor {
    private final int groupId;
    private final int popQuizId;

    public LecturerCustomAuthenticationInteractor(RequestSender requestSender, Intent intent) {
        super(requestSender);
        groupId = intent.getIntExtra("groupId", -1);
        popQuizId = intent.getIntExtra("popQuizId", -1);
    }

    public void getStudents(final StandardGenericResponseHandler<ArrayList<StudentListItem>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(groupId, new StandardGenericResponseHandler<ArrayList<Student>>() {
            @Override
            public void onSuccess(ArrayList<Student> responseObject) {
                standardGenericResponseHandler.onSuccess(mapStudents(responseObject));
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
}
