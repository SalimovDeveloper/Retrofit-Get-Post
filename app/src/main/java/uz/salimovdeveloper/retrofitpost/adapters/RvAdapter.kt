package uz.salimovdeveloper.retrofitpost.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.salimovdeveloper.retrofitpost.databinding.ItemRecycBinding
import uz.salimovdeveloper.retrofitpost.models.MyTodoGetResponse

class RvAdapter(var list: List<MyTodoGetResponse>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRecycBinding: ItemRecycBinding) : RecyclerView.ViewHolder(itemRecycBinding.root) {
        fun onBind(myTodoGetResponse: MyTodoGetResponse) {
            itemRecycBinding.itemName.text = myTodoGetResponse.sarlavha
            itemRecycBinding.iemMatn.text = myTodoGetResponse.matn
            itemRecycBinding.itemDate.text = myTodoGetResponse.oxirgi_muddat
            itemRecycBinding.itemXolati.text = myTodoGetResponse.holat

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRecycBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}