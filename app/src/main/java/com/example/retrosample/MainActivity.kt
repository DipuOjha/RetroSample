package com.example.retrosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var retroService: RetroService
    lateinit var myVmFactory: myVmFactory
    lateinit var vm: myVm
    lateinit var myrepo:repo
    lateinit var adapter: myAdapter
     var mylist:ArrayList<TodosItem> = ArrayList()
    lateinit var recView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*   vm.dataforview.observe(this, Observer {
            Log.d("HIII",it.toString())
            mylist = it
        })*/

        init()
        initrec()

        vm.dataforview.observe(this, Observer {
            Log.d("HIII",it.toString())
          /*  mylist = it.map {
                it.title
            } as ArrayList<String>
        })*/
            mylist = it
            Log.d("MyList",mylist.toString())
          //  initrec()
            adapter.setList(it)
        })

       // Log.d("Hii",mylist.toString())



        // adapter.notifyDataSetChanged()

    }

  /*  override fun onStart() {
        super.onStart()



    }*/
    fun init(){
        retroService = RetroBuilder.getRetro()!!
        myrepo = repo(retroService)
        myVmFactory = myVmFactory(myrepo)
        vm = ViewModelProvider(this,myVmFactory).get(myVm::class.java)
        recView = findViewById(R.id.recview)


    }
    fun initrec(){
        recView.layoutManager = LinearLayoutManager(this)
        adapter = myAdapter()
        recView.adapter = adapter
        Log.d("Hiii","adapter set")

    }
}