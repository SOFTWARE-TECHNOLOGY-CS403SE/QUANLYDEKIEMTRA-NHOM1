using DevExpress.Data.Filtering;
using DevExpress.ExpressApp;
using DevExpress.ExpressApp.DC;
using DevExpress.ExpressApp.Model;
using DevExpress.Persistent.Base;
using DevExpress.Persistent.BaseImpl;
using DevExpress.Persistent.BaseImpl.PermissionPolicy;
using DevExpress.Persistent.Validation;
using DevExpress.Xpo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Text;

namespace DXApplication1.Module.BusinessObjects
{
    [DefaultClassOptions]
    [System.ComponentModel.DisplayName("Bài kiểm tra")]
    [DefaultProperty("Tenbaikiemtra")]

    //[ImageName("BO_Contact")]
    [DefaultListViewOptions(MasterDetailMode.ListViewOnly, true, NewItemRowPosition.Top)]
    //[Persistent("DatabaseTableName")]
    // Specify more UI options using a declarative approach (https://documentation.devexpress.com/#eXpressAppFramework/CustomDocument112701).
    public class BAIKIEMTRA : BaseObject
    { // Inherit from a different class to provide a custom primary key, concurrency and deletion behavior, etc. (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument113146.aspx).
      // Use CodeRush to create XPO classes and properties with a few keystrokes.
      // https://docs.devexpress.com/CodeRushForRoslyn/118557

        public BAIKIEMTRA(Session session)
            : base(session)
        {
        }
        public override void AfterConstruction()
        {
            base.AfterConstruction();
            //if (SecuritySystem.CurrentUser != null)
              
            // Place your initialization code here (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument112834.aspx).
        }



        private string _tenbaikiemtra;
        [XafDisplayName("Tên bài kiểm tra"), Size(255)]
        public string Tenbaikiemtra
        {
            get { return _tenbaikiemtra; }
            set { SetPropertyValue<string>(nameof(Tenbaikiemtra), ref _tenbaikiemtra, value); }
        }

        private string _mota;
        [XafDisplayName("Mô tả"), Size(int.MaxValue)]
        public string Mota
        {
            get { return _mota; }
            set { SetPropertyValue<string>(nameof(Mota), ref _mota, value); }
        }
    

        private int _thoigianlambai;
        [XafDisplayName("Thời gian làm bài")]
        public int Thoigianlambai
        {
            get { return _thoigianlambai; }
            set { SetPropertyValue<int>(nameof(Thoigianlambai), ref _thoigianlambai, value); }
        }

        [DevExpress.Xpo.Aggregated, Association]
        [XafDisplayName("Chi tiết bài kiểm tra")]
        public XPCollection<BAIKIEMTRA_CHITIET> BAIKIEMTRA_CHITIETs
        {
            get { return GetCollection<BAIKIEMTRA_CHITIET>(nameof(BAIKIEMTRA_CHITIETs)); }
        }


    }
}