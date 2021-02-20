

import java.lang.*;

public interface IUsersRepo
{
	Users getUser(String userId, String password);
	void insertUser(Users u);
	void updateUser(Users u);
	void deleteUser(String userId);
}