using DevExpress.Data.Filtering;
using DevExpress.ExpressApp;
using DevExpress.ExpressApp.DC;
using DevExpress.ExpressApp.Model;
using DevExpress.Persistent.Base;
using DevExpress.Persistent.BaseImpl;
using DevExpress.Persistent.Validation;
using DevExpress.Xpo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;

namespace DXApplication1.Module.BusinessObjects
{
    [DefaultClassOptions]
    [System.ComponentModel.DisplayName("Câu hỏi")]
    //[ImageName("BO_Contact")]
    [DefaultProperty("Cauhoi")]
    [DefaultListViewOptions(MasterDetailMode.ListViewOnly, true, NewItemRowPosition.Top)]
    //[Persistent("DatabaseTableName")]
    // Specify more UI options using a declarative approach (https://documentation.devexpress.com/#eXpressAppFramework/CustomDocument112701).
    public class CAUHOI : BaseObject
    { // Inherit from a different class to provide a custom primary key, concurrency and deletion behavior, etc. (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument113146.aspx).
        // Use CodeRush to create XPO classes and properties with a few keystrokes.
        // https://docs.devexpress.com/CodeRushForRoslyn/118557
        public CAUHOI(Session session)
            : base(session)
        {
        }
        public override void AfterConstruction()
        {
            base.AfterConstruction();
            // Place your initialization code here (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument112834.aspx).
        }



        private string _cauhoi;
        [XafDisplayName("Câu hỏi"), Size(int.MaxValue)]
        public string Cauhoi
        {
            get { return _cauhoi; }
            set { SetPropertyValue<string>(nameof(Cauhoi), ref _cauhoi, value); }
        }

        private string _dapan1;
        [XafDisplayName("Đáp án 1"), Size(int.MaxValue)]
        public string Dapan1
        {
            get { return _dapan1; }
            set { SetPropertyValue<string>(nameof(Dapan1), ref _dapan1, value); }
        }

        private string _dapan2;
        [XafDisplayName("Đáp án 2"), Size(int.MaxValue)]
        public string Dapan2
        {
            get { return _dapan2; }
            set { SetPropertyValue<string>(nameof(Dapan2), ref _dapan2, value); }
        }

        private string _dapan3;
        [XafDisplayName("Đáp án 3"), Size(int.MaxValue)]
        public string Dapan3
        {
            get { return _dapan3; }
            set { SetPropertyValue<string>(nameof(Dapan3), ref _dapan3, value); }
        }

        private string _dapan4;
        [XafDisplayName("Đáp án 4"), Size(int.MaxValue)]
        public string Dapan4
        {
            get { return _dapan4; }
            set { SetPropertyValue<string>(nameof(Dapan4), ref _dapan4, value); }
        }

        private string _giaithich;
        [XafDisplayName("Giải thích"), Size(int.MaxValue)]
        public string Giaithich
        {
            get { return _giaithich; }
            set { SetPropertyValue<string>(nameof(Giaithich), ref _giaithich, value); }
        }


        [DevExpress.Xpo.Aggregated, Association]
        [XafDisplayName("Chi tiết bài kiểm tra")]
        public XPCollection<BAIKIEMTRA_CHITIET> BAIKIEMTRA_CHITIETs
        {
            get { return GetCollection<BAIKIEMTRA_CHITIET>(nameof(BAIKIEMTRA_CHITIETs)); }
        }




    }
}