package costa.barreto.picpay.features.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import costa.barreto.picpay.databinding.ItemListContactBinding
import costa.barreto.picpay.features.contact.model.Contact

class AdapterContact :
    RecyclerView.Adapter<AdapterContact.ViewHolder>, Filterable, AdapterItemsContract {

    var list: List<Contact>
    lateinit var filterList: List<Contact>
    var filterContact: FilterContact? = null
    private val itemClick: (Contact) -> Unit

    constructor(list: List<Contact>, itemClick: (Contact) -> Unit) {
        this.list = list
        //this.filterList = list
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListContactBinding =
            ItemListContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding,itemClick)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binView(list[position])

    }

    class ViewHolder(
        private val binding: ItemListContactBinding,
        val itemClick: (Contact) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun binView(contact: Contact) {
            with(contact) {
                binding.root.setOnClickListener { itemClick(this) }
            }
            binding.contact = contact
            binding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        if (filterContact == null) {
            filterContact = FilterContact(
                filterList,
                this
            )
        }
        return filterContact as FilterContact
    }

    override fun replaceItems(list: List<*>) {
        this.list = list as List<Contact>
        this.filterList = this.list
        notifyDataSetChanged()
    }

}