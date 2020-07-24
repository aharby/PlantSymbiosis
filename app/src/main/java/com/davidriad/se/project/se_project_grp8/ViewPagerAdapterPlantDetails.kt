package com.davidriad.se.project.se_project_grp8

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapterPlantDetails internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment =
                HelpsFragment()
        when (position) {
            0 -> fragment = HelpsFragment()
            1 -> fragment = HelpsFragment()
            2 -> fragment = HelpsFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return Companion.count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position==0) return "Helps"
        else if(position == 1 ) return "Helped by"
        else return "Avoid"
    }

    companion object {
        private const val count = 3
    }
}
