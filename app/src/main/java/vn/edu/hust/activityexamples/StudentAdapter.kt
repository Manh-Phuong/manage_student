package vn.edu.hust.activityexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>, private val onItemClick: (Student) -> Unit) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val mssvTextView: TextView = itemView.findViewById(R.id.mssv)
        val emailTextView: TextView = itemView.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.nameTextView.text = student.fullName
        holder.mssvTextView.text = student.studentId.toString()
        holder.emailTextView.text = student.email
//        holder.emailTextView.text = getEmailFromStudent(student)

        holder.itemView.setOnClickListener { onItemClick(student) }
    }

    override fun getItemCount(): Int = students.size

    fun getItem(position: Int): Student {
        return students[position]
    }

//    private fun getEmailFromStudent(student: Student): String {
//        // Tách họ và tên
//        val fullNameParts = student.fullName.split(" ")
//
//        // Lấy ký tự đầu của họ và tên
//        val firstNameInitial = student.fullName.substringAfterLast(" ").toLowerCase()
//        val lastNameInitial = fullNameParts.firstOrNull()?.firstOrNull()?.toLowerCase() ?: ""
//
//        // Tạo email từ MSSV và Họ tên
//        val emailPrefix = "$firstNameInitial.$lastNameInitial${student.studentId}"
//
//        return "$emailPrefix@sis.hust.edu.vn"
//    }

//    private fun getInitialsFromFullName(fullName: String): String {
//        val nameParts = fullName.trim().split(" ")
//
//        // Khởi tạo một StringBuilder để xây dựng chuỗi kết quả
//        val initialsBuilder = StringBuilder()
//
//        // Duyệt qua tất cả các từ trừ từ cuối cùng
//        for (i in 0 until nameParts.size - 1) {
//            // Lấy ký tự đầu của từ và thêm vào StringBuilder
//            initialsBuilder.append(nameParts[i].get(0))
//        }
//
//        return initialsBuilder.toString().lowercase()
//    }
//
//    private fun getEmailFromStudent(student: Student): String {
//        // Lấy ký tự đầu của những từ trừ từ cuối cùng từ tên
//        val initials = getInitialsFromFullName(student.fullName)
//
//        // Lấy phần cuối cùng của tên từ chuỗi
//        val lastName = student.fullName.substringAfterLast(" ").lowercase()
//
//        // Chuyển đổi studentId thành Int trước khi lấy substring
//        val studentIdSubstring = student.studentId.toString().substring(2, 8)
//
//
//        val emailPrefix = "$lastName.$initials$studentIdSubstring"
//
//        return "$emailPrefix@sis.hust.edu.vn"
//    }




}
