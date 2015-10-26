package android.joeamrhein.example;

import android.joeamrhein.library.CVDetail;
import android.joeamrhein.library.CompanyTitle;
import android.joeamrhein.library.EducationEntry;
import android.joeamrhein.library.MobileCVActivity;
import android.joeamrhein.library.SectionTitle;
import android.joeamrhein.library.WorkHighlightEntry;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startActivity(MobileCVActivity.createIntent(this, "Tyler Durden", "https://daleylife.files.wordpress.com/2013/07/tumblr_mqckwkatmg1st51fio4_500.jpg", createExampleDetails()));
    }


    public static ArrayList<CVDetail> createExampleDetails() {
        ArrayList<CVDetail> details = new ArrayList<>();

        details.add(new SectionTitle("Career Highlights"));

        details.add(new CompanyTitle("ABC Inc.", 2014));
        details.add(new WorkHighlightEntry("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        details.add(new WorkHighlightEntry("Vestibulum dictum enim non diam semper, id ornare metus elementum."));
        details.add(new WorkHighlightEntry("Pellentesque dapibus eros vel ultricies dictum."));

        details.add(new CompanyTitle("XYZ Corporation", 2011, 2014));
        details.add(new WorkHighlightEntry("Maecenas efficitur felis non iaculis sagittis"));
        details.add(new WorkHighlightEntry("Phasellus condimentum metus ac porttitor efficitur."));
        details.add(new WorkHighlightEntry("Fusce eu sem non elit lacinia efficitur a dapibus urna."));

        details.add(new CompanyTitle("Small Startup", 2010, 2011));
        details.add(new WorkHighlightEntry("Sed pulvinar turpis et nisl gravida hendrerit."));
        details.add(new WorkHighlightEntry("Aliquam congue velit non ligula rhoncus, sit amet hendrerit lorem ornare."));
        details.add(new WorkHighlightEntry("Nullam viverra dui in mauris vehicula lobortis."));
        details.add(new WorkHighlightEntry("Vivamus posuere odio vitae congue consequat."));

        details.add(new CompanyTitle("Large Conglomerate", 2006, 2010));
        details.add(new WorkHighlightEntry("Aliquam ut lectus eget purus pharetra condimentum."));
        details.add(new WorkHighlightEntry("Sed nec nibh vitae eros ultrices pulvinar sed at magna."));
        details.add(new WorkHighlightEntry("Nam porta metus sed diam tempor, sed rhoncus velit malesuada."));

        details.add(new SectionTitle("Education"));

        details.add(new EducationEntry("Bachelor of Science in Computer Engineering", "University of Computing", 2006));
        details.add(new EducationEntry("Masters of Science in Computer Engineering", "University of Quantum Computing", 2013));

        return details;
    }
}
