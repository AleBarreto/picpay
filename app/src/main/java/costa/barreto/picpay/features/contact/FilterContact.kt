package costa.barreto.picpay.features.contact

import android.widget.Filter
import costa.barreto.picpay.features.contact.model.Contact

class FilterContact : Filter {

    val listFilter: List<Contact>
    val adapterContact: AdapterContact

    constructor(listFilter: List<Contact>, adapterContact: AdapterContact) {
        this.listFilter = listFilter
        this.adapterContact = adapterContact
    }

    override fun performFiltering(_constraint: CharSequence?): FilterResults {
        var constraint = _constraint
        val results = FilterResults()
        if (constraint != null && constraint.length > 0) {
            constraint = constraint.toString().toUpperCase()
            val filteredContact: ArrayList<Contact> = arrayListOf()
            for (contact in listFilter) {
                if (contact.name.toUpperCase().contains(constraint) || contact.username.toUpperCase().contains(
                        constraint
                    )
                ) {
                    filteredContact.add(contact)
                }
            }
            results.count = filteredContact.size
            results.values = filteredContact

        }
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        if (results?.values != null) {
            adapterContact.list = results.values as List<Contact>
            adapterContact.notifyDataSetChanged()
        } else {
            adapterContact.list = listFilter
            adapterContact.notifyDataSetChanged()
        }

    }
}