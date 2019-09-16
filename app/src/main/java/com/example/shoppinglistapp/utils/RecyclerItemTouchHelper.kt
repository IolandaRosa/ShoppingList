package com.example.shoppinglistapp.utils

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.adapter.ProductListFragmentAdapter

class RecyclerItemTouchHelper(val listener: RecyclerItemTouchHelperListener) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {

        if (viewHolder != null) {
            val foregroundView =
                (viewHolder as ProductListFragmentAdapter.ProductViewHolder).foregroundLayout

            ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(foregroundView)
        }
    }

    override fun onChildDrawOver(
        c: Canvas, recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float,
        actionState: Int, isCurrentlyActive: Boolean
    ) {

        val foregroundView =
            (viewHolder as ProductListFragmentAdapter.ProductViewHolder).foregroundLayout

        ItemTouchHelper.Callback.getDefaultUIUtil().onDrawOver(
            c, recyclerView, foregroundView, dX, dY,
            actionState, isCurrentlyActive
        )
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val foregroundView =
            (viewHolder as ProductListFragmentAdapter.ProductViewHolder).foregroundLayout

        ItemTouchHelper.Callback.getDefaultUIUtil().clearView(foregroundView)
    }

    override fun onChildDraw(
        c: Canvas, recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float,
        actionState: Int, isCurrentlyActive: Boolean
    ) {
        val foregroundView =
            (viewHolder as ProductListFragmentAdapter.ProductViewHolder).foregroundLayout

        ItemTouchHelper.Callback.getDefaultUIUtil().onDraw(
            c, recyclerView, foregroundView, dX / 2, dY,
            actionState, isCurrentlyActive
        )
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

        if (direction == ItemTouchHelper.LEFT) {
            listener.onSwipeDelete(viewHolder.layoutPosition)
        } else {
            listener.onSwipeUpdate(viewHolder.layoutPosition)
        }
    }

    interface RecyclerItemTouchHelperListener {
        fun onSwipeDelete(position: Int)

        fun onSwipeUpdate(position: Int)
    }

}