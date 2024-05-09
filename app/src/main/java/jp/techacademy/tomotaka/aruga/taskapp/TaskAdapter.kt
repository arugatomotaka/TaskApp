package jp.techacademy.tomotaka.aruga.taskapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//クラスの説明：アダプターを用いてデータとビューを繋ぐためのコード
//baseadapterはアダプターの基本的な実装を提供する抽象クラス


class TaskAdapter(context: Context) : BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private var taskList = mutableListOf<Task>()

    init {
        this.layoutInflater = LayoutInflater.from(context)
    }
    //getCount：アダプターが保持するデータの数を返します。ここでは、タスクリストのサイズを返しています。
    override fun getCount(): Int {
        return taskList.size
    }
     //getItem：指定した位置のデータを返します。ここでは、タスクリストの指定した位置のタスクを返しています。
    override fun getItem(position: Int): Any {
        return taskList[position]
    }
    //getItemId：指定した位置のデータのIDを返します。ここでは、タスクのIDを返しています。
    override fun getItemId(position: Int): Long {
        return taskList[position].id.toLong()
    }
//
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View =
            convertView ?: layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)

        val textView1 = view.findViewById<TextView>(android.R.id.text1)
        val textView2 = view.findViewById<TextView>(android.R.id.text2)

        textView1.text = taskList[position].title
        textView2.text = taskList[position].date

        return view
    }

    fun updateTaskList(taskList: List<Task>) {
        // 一度クリアしてから新しいタスク一覧に入替
        this.taskList.clear()
        this.taskList.addAll(taskList)
        // データに変更があったことをadapterに通知
        notifyDataSetChanged()
    }
}