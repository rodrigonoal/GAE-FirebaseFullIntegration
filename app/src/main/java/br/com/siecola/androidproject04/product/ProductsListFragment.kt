package br.com.siecola.androidproject04.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import br.com.siecola.androidproject04.databinding.FragmentProductsListBinding

private const val TAG = "ProductsListFragment"

class ProductsListFragment: Fragment() {
    private val productViewModel: ProductListViewModel by lazy {
        ViewModelProvider(this).get(ProductListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductsListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.productListViewModel = productViewModel

        val itemDecor = DividerItemDecoration(context, VERTICAL)

        binding.rcvProducts.addItemDecoration(itemDecor)

        binding.rcvProducts.adapter =
            ProductAdapter(ProductAdapter.ProductClickListener { product ->
                Log.i(TAG, "Product selected: ${product.code}")

                this.findNavController()
                    .navigate(ProductsListFragmentDirections.actionShowProductDetail(product.code!!))
            })

        return binding.root
    }
}